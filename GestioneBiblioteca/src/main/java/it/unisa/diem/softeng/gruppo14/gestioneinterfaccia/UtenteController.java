package it.unisa.diem.softeng.gruppo14.gestioneinterfaccia;

import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import java.net.URL;
import java.util.ResourceBundle;
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
 * @brief Classe che gestisce l'interfaccia degli utenti presenti nell'archivio.
 * 
 * La classe gestisce le azioni relative alla visualizzazione e manipolazione
 * dei dati degli utenti, come l'aggiunta, la modifica e la rimozione 
 * degli utenti nella tabella.
 * 
 * @author gruppo14
 */

public class UtenteController implements Initializable {

    @FXML private TableView<Utente> userTable1;
    @FXML private TableColumn<Utente, String> surnameClm1;
    @FXML private TableColumn<Utente, String> nameClm1;
    @FXML private TableColumn<Utente, String> codeClm1;
    @FXML private TableColumn<Utente, String> mailClm1;

    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField codeField;
    @FXML private TextField mailField;

    @FXML private TextField userSearchField;

    private FilteredList<Utente> filtered;

    /**
     * @brief Inizializza il controller.
     * 
     * Il metodo inizializza gli elementi dell'interfaccia utente e 
     * prepara la logica per le azioni relative 
     * alla gestione della lista degli utenti.
     * 
     * @param[in] url Percorso del file FXML associato al controller.
     * @param[in] rb Collezione di risorse localizzate per l'applicazione.
     * 
     * @post Gli attributi non statici sono stati inizializzati.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        surnameClm1.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getCognome())));
        nameClm1.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getNome())));
        codeClm1.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getMatricola())));
        mailClm1.setCellValueFactory(c -> new SimpleStringProperty(safe(c.getValue().getEmail())));

        SchermataPrincipaleController.Shared.refreshAll();
        filtered = new FilteredList<Utente>(SchermataPrincipaleController.Shared.utentiObs, u -> true);
        userTable1.setItems(filtered);

        userSearchField.textProperty().addListener((o, old, q) -> {
            final String query = safe(q).toLowerCase();
            filtered.setPredicate(u -> {
                if (query.isEmpty()) return true;
                return safe(u.getNome()).toLowerCase().contains(query)
                        || safe(u.getCognome()).toLowerCase().contains(query)
                        || safe(u.getMatricola()).toLowerCase().contains(query)
                        || safe(u.getEmail()).toLowerCase().contains(query);
            });
        });

        userTable1.getSelectionModel().selectedItemProperty().addListener((o, old, sel) -> {
            if (sel == null) {
                clearForm();
                return;
            }
            nameField.setText(sel.getNome());
            surnameField.setText(sel.getCognome());
            codeField.setText(sel.getMatricola());
            mailField.setText(sel.getEmail());
        });
    }

    @FXML
    private void aggiungiUtenteBtn(ActionEvent event) {
        try {
            Utente nuovo = buildUtenteFromFields();
            SchermataPrincipaleController.Shared.gestioneUtenti.aggiungiUtente(nuovo);
            SchermataPrincipaleController.Shared.refreshAll();

            clearAndUnselect();

            SchermataPrincipaleController.showInfo("Utente aggiunto", "Utente inserito correttamente.");
        } catch (RuntimeException ex) {
            SchermataPrincipaleController.showError("Aggiunta utente non riuscita", ex.getMessage());
        }
    }

    @FXML
    private void modificaUtenteBtn(ActionEvent event) {
        Utente selezionato = userTable1.getSelectionModel().getSelectedItem();
        if (selezionato == null) {
            SchermataPrincipaleController.showError("Modifica utente", "Seleziona un utente dalla tabella.");
            return;
        }

        try {
            Utente aggiornato = buildUtenteFromFields();

            if (!safe(selezionato.getMatricola()).equals(safe(aggiornato.getMatricola()))) {
                boolean exists = SchermataPrincipaleController.Shared.gestioneUtenti.getUtenti().stream()
                        .anyMatch(u -> safe(u.getMatricola()).equals(safe(aggiornato.getMatricola())));
                if (exists) throw new IllegalArgumentException("Matricola già presente nel sistema.");
            }

            SchermataPrincipaleController.Shared.gestioneUtenti.modificaUtente(selezionato, aggiornato);
            SchermataPrincipaleController.Shared.refreshAll();
            userTable1.refresh();

            clearAndUnselect();

            SchermataPrincipaleController.showInfo("Utente modificato", "Utente modificato correttamente.");
        } catch (RuntimeException ex) {
            SchermataPrincipaleController.showError("Modifica utente non riuscita", ex.getMessage());
        }
    }

    @FXML
    private void rimuoviUtenteBtn(ActionEvent event) {
        Utente selezionato = userTable1.getSelectionModel().getSelectedItem();
        if (selezionato == null) {
            SchermataPrincipaleController.showError("Rimozione utente", "Seleziona un utente dalla tabella.");
            return;
        }

        try {
            SchermataPrincipaleController.Shared.gestioneUtenti.eliminaUtente(
                    selezionato,
                    SchermataPrincipaleController.Shared.gestionePrestiti.getPrestiti()
            );
            SchermataPrincipaleController.Shared.refreshAll();

            clearAndUnselect();

            SchermataPrincipaleController.showInfo("Utente eliminato", "Utente rimosso correttamente.");
        } catch (RuntimeException ex) {
            SchermataPrincipaleController.showError("Rimozione utente non riuscita", ex.getMessage());
        }
    }

    private void clearAndUnselect() {
        clearForm();
        Platform.runLater(() -> userTable1.getSelectionModel().clearSelection());
    }

    private Utente buildUtenteFromFields() {
        return new Utente(
                safe(nameField.getText()),
                safe(surnameField.getText()),
                safe(codeField.getText()),
                safe(mailField.getText())
        );
    }

    private static String safe(String s) {
        return s == null ? "" : s.trim();
    }

    private void clearForm() {
        nameField.clear();
        surnameField.clear();
        codeField.clear();
        mailField.clear();
    }
}
