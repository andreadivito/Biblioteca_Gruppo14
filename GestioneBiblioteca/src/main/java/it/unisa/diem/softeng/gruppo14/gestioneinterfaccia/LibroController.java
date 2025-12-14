package it.unisa.diem.softeng.gruppo14.gestioneinterfaccia;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @brief Classe che gestisce l'interfaccia dei libri presenti nell'archivio.
 * 
 * La classe gestisce le azioni relative alla visualizzazione e manipolazione
 * dei dati dei libri, come l'aggiunta, la modifica e la rimozione 
 * dei libri nella tabella.
 *
 * @author gruppo14
 */
public class LibroController implements Initializable {

    @FXML private TableView<Libro> bookTable1;
    @FXML private TableColumn<Libro, String> titleClm1;
    @FXML private TableColumn<Libro, String> authorClm1;
    @FXML private TableColumn<Libro, String> pubYearClm1;
    @FXML private TableColumn<Libro, String> isbnClm1;
    @FXML private TableColumn<Libro, String> numCopiesClm1;

    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField pubYearField;
    @FXML private TextField isbnField;
    @FXML private TextField numCopiesField;

    @FXML private TextField bookSearchField;

    private FilteredList<Libro> filtered;

    /**
     * @brief Inizializza il controller.
     * 
     * Il metodo inizializza gli elementi dell'interfaccia utente e 
     * prepara la logica per le azioni relative 
     * alla gestione della lista dei libri.
     * 
     * @param[in] url Percorso del file FXML associato al controller.
     * @param[in] rb Collezione di risorse localizzate per l'applicazione.
     * 
     * @post Gli attributi non statici sono stati inizializzati.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titleClm1.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getTitolo())));
        authorClm1.setCellValueFactory(c -> new SimpleStringProperty(String.join(", ", c.getValue().getAutori())));
        pubYearClm1.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getAnnoPubblicazione())));
        isbnClm1.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getISBN())));
        numCopiesClm1.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getNumCopie())));

        SchermataPrincipaleController.Shared.refreshAll();
        filtered = new FilteredList<Libro>(SchermataPrincipaleController.Shared.libriObs, b -> true);
        bookTable1.setItems(filtered);

        bookSearchField.textProperty().addListener((o, old, q) -> {
            final String query = safe(q).toLowerCase();
            filtered.setPredicate(l -> {
                if (query.isEmpty()) return true;
                if (safe(l.getTitolo()).toLowerCase().contains(query)) return true;
                if (safe(l.getISBN()).toLowerCase().contains(query)) return true;
                return l.getAutori() != null && l.getAutori().stream()
                        .anyMatch(a -> safe(a).toLowerCase().contains(query));
            });
        });

        bookTable1.getSelectionModel().selectedItemProperty().addListener((o, old, sel) -> {
            if (sel == null) {
                clearForm();
                return;
            }
            titleField.setText(sel.getTitolo());
            authorField.setText(String.join(", ", sel.getAutori()));
            pubYearField.setText(String.valueOf(sel.getAnnoPubblicazione()));
            isbnField.setText(sel.getISBN());
            numCopiesField.setText(String.valueOf(sel.getNumCopie()));
        });
    }

    @FXML
    private void aggiungiLibroBtn(ActionEvent event) {
        try {
            Libro nuovo = buildLibroFromFields();
            SchermataPrincipaleController.Shared.gestioneLibri.aggiungiLibro(nuovo);
            SchermataPrincipaleController.Shared.refreshAll();

            clearAndUnselect();

            SchermataPrincipaleController.showInfo("Libro aggiunto", "Libro inserito correttamente.");
        } catch (RuntimeException ex) {
            SchermataPrincipaleController.showError("Aggiunta libro non riuscita", ex.getMessage());
        }
    }

    @FXML
    private void modificaLibroBtn(ActionEvent event) {
        Libro selezionato = bookTable1.getSelectionModel().getSelectedItem();
        if (selezionato == null) {
            SchermataPrincipaleController.showError("Modifica libro", "Seleziona un libro dalla tabella.");
            return;
        }

        try {
            Libro aggiornato = buildLibroFromFields();

            if (!safe(selezionato.getISBN()).equals(safe(aggiornato.getISBN()))) {
                boolean exists = SchermataPrincipaleController.Shared.gestioneLibri.getLibri().stream()
                        .anyMatch(l -> safe(l.getISBN()).equals(safe(aggiornato.getISBN())));
                if (exists) throw new IllegalArgumentException("Esiste già un libro con questo ISBN: " + aggiornato.getISBN());
            }

            SchermataPrincipaleController.Shared.gestioneLibri.modificaLibro(selezionato, aggiornato);
            SchermataPrincipaleController.Shared.refreshAll();
            bookTable1.refresh();

            clearAndUnselect();

            SchermataPrincipaleController.showInfo("Libro modificato", "Libro modificato correttamente.");
        } catch (RuntimeException ex) {
            SchermataPrincipaleController.showError("Modifica libro non riuscita", ex.getMessage());
        }
    }

    @FXML
    private void rimuoviLibroBtn(ActionEvent event) {
        Libro selezionato = bookTable1.getSelectionModel().getSelectedItem();
        if (selezionato == null) {
            SchermataPrincipaleController.showError("Elimina libro", "Seleziona un libro dalla tabella.");
            return;
        }

        try {
            SchermataPrincipaleController.Shared.gestioneLibri.eliminaLibro(
                    selezionato,
                    SchermataPrincipaleController.Shared.gestionePrestiti.getPrestiti()
            );
            SchermataPrincipaleController.Shared.refreshAll();

            clearAndUnselect();

            SchermataPrincipaleController.showInfo("Libro eliminato", "Libro rimosso correttamente.");
        } catch (RuntimeException ex) {
            SchermataPrincipaleController.showError("Eliminazione libro non riuscita", ex.getMessage());
        }
    }

    private void clearAndUnselect() {
        clearForm();
        Platform.runLater(() -> bookTable1.getSelectionModel().clearSelection());
    }

    private Libro buildLibroFromFields() {
        String titolo = safe(titleField.getText());
        List<String> autori = parseAutori(authorField.getText());
        int anno = parseInt(pubYearField.getText(), "Anno di pubblicazione");
        String isbn = safe(isbnField.getText());
        int copie = parseInt(numCopiesField.getText(), "Numero copie");
        return new Libro(titolo, autori, anno, isbn, copie);
    }

    private static List<String> parseAutori(String s) {
        if (s == null) return new ArrayList<String>();
        return Arrays.stream(s.split(","))
                .map(String::trim)
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());
    }

    private static int parseInt(String s, String fieldName) {
        try {
            return Integer.parseInt(safe(s));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(fieldName + " non valido.");
        }
    }

    private static String safe(String s) {
        return s == null ? "" : s.trim();
    }

    private void clearForm() {
        titleField.clear();
        authorField.clear();
        pubYearField.clear();
        isbnField.clear();
        numCopiesField.clear();
 }
}
