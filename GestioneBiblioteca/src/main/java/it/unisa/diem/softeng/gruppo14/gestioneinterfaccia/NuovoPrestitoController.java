package it.unisa.diem.softeng.gruppo14.gestioneinterfaccia;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @brief Classe che gestisce l'interfaccia relativa all'aggiunta di un nuovo prestito.
 * 
 * La classe gestisce le azioni relative alla creazione di un nuovo prestito.
 * Permette di selezionare un libro, un utente e impostare la data 
 * di restituzione di un prestito.
 * 
 * @author gruppo14 
 */
public class NuovoPrestitoController implements Initializable {

    @FXML private TableView<Utente> userTable;
    @FXML private TableColumn<Utente, String> surnameClm;
    @FXML private TableColumn<Utente, String> nameClm;
    @FXML private TableColumn<Utente, String> codeClm;
    @FXML private TableColumn<Utente, String> mailClm;

    @FXML private TableView<Libro> bookTable;
    @FXML private TableColumn<Libro, String> titleClm;
    @FXML private TableColumn<Libro, String> authorClm;
    @FXML private TableColumn<Libro, String> pubYearClm;
    @FXML private TableColumn<Libro, String> isbnClm;
    @FXML private TableColumn<Libro, String> numCopiesClm;

    @FXML private TextField dateLimitField;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * @brief Inizializza il controller.
     * 
     * Il metodo inizializza gli elementi dell'interfaccia utente 
     * e prepara la logica per le azioni relative 
     * alla gestione di un nuovo prestito.
     *
     * @param[in] url Percorso del file FXML associato al controller.
     * @param[in] rb Collezione di risorse localizzate per l'applicazione.
     * 
     * @post Gli attributi non statici sono stati inizializzati.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        surnameClm.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getCognome())));
        nameClm.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getNome())));
        codeClm.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getMatricola())));
        mailClm.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getEmail())));

        titleClm.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getTitolo())));
        authorClm.setCellValueFactory(c -> new SimpleStringProperty(String.join(", ", c.getValue().getAutori())));
        pubYearClm.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getAnnoPubblicazione())));
        isbnClm.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getISBN())));
        numCopiesClm.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getNumCopie())));

        SchermataPrincipaleController.Shared.refreshAll();
        userTable.setItems(SchermataPrincipaleController.Shared.utentiObs);
        bookTable.setItems(SchermataPrincipaleController.Shared.libriObs);
    }

   @FXML
private void aggiungiPrestitoBtn(ActionEvent event) {
    Utente u = userTable.getSelectionModel().getSelectedItem();
    Libro l = bookTable.getSelectionModel().getSelectedItem();

    if (u == null || l == null) {
        SchermataPrincipaleController.showError("Nuovo prestito", "Seleziona un utente e un libro.");
        return;
    }

    LocalDate dataRest;
    try {
        dataRest = LocalDate.parse(safe(dateLimitField.getText()), DTF);
    } catch (DateTimeParseException ex) {
        SchermataPrincipaleController.showError("Data non valida", "Inserisci la data come GG/MM/AAAA (es. 31/12/2025).");
        return;
    }

    if (dataRest.isBefore(LocalDate.now())) {
        SchermataPrincipaleController.showError("Data non valida", "La data di restituzione non può essere nel passato.");
        return;
    }

    int prestitiSuLibro = 0;
    String isbn = safe(l.getISBN());
    for (Prestito p : SchermataPrincipaleController.Shared.gestionePrestiti.getPrestiti()) {
        if (p != null && p.getLibro() != null && safe(p.getLibro().getISBN()).equals(isbn)) {
            prestitiSuLibro++;
        }
    }

    if (prestitiSuLibro >= l.getNumCopie()) {
        SchermataPrincipaleController.showError("Prestito non possibile", "Copie finite: il libro risulta già tutto in prestito.");
        return;
    }

    String matricola = safe(u.getMatricola());
    for (Prestito p : SchermataPrincipaleController.Shared.gestionePrestiti.getPrestiti()) {
        if (p != null && p.getLibro() != null && p.getUtente() != null
                && safe(p.getLibro().getISBN()).equals(isbn)
                && safe(p.getUtente().getMatricola()).equals(matricola)) {
            SchermataPrincipaleController.showError("Prestito non possibile", "Questo utente ha già in prestito questo libro.");
            return;
        }
    }

    int prima = SchermataPrincipaleController.Shared.gestionePrestiti.getPrestiti().size();

    try {
        SchermataPrincipaleController.Shared.gestionePrestiti.registraPrestito(l, u, dataRest);
        SchermataPrincipaleController.Shared.refreshAll();

        int dopo = SchermataPrincipaleController.Shared.gestionePrestiti.getPrestiti().size();
        if (dopo <= prima) {
            SchermataPrincipaleController.showError("Prestito non registrato", "Operazione non completata (nessun prestito aggiunto).");
            return;
        }

        userTable.refresh();
        bookTable.refresh();

        dateLimitField.clear();
        Platform.runLater(() -> {
            userTable.getSelectionModel().clearSelection();
            bookTable.getSelectionModel().clearSelection();
        });

        SchermataPrincipaleController.showInfo("Prestito registrato", "Prestito aggiunto correttamente.");
    } catch (RuntimeException ex) {
        SchermataPrincipaleController.showError("Registrazione prestito non riuscita", ex.getMessage());
        }
}

    private static String safe(String s) {
        return s == null ? "" : s.trim();
    }
}
