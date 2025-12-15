package it.unisa.diem.softeng.gruppo14.gestioneinterfaccia;

import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

/**
 * @brief Classe che gestisce l'interfaccia dei prestiti attivi.
 * 
 * La classe gestisce le azioni relative alla visualizzazione e manipolazione 
 * dei prestiti attivi. Permette di vedere i prestiti in corso e rimuovere un prestito.
 * 
 * @author gruppo14 
 */
public class PrestitoAttivoController implements Initializable {

    @FXML private TableView<Prestito> LoanTable;
    @FXML private TableColumn<Prestito, String> loanBookTitleClm;
    @FXML private TableColumn<Prestito, String> loanUserClm;
    @FXML private TableColumn<Prestito, String> dateLimitClm;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * @brief Inizializza il controller.
     * 
     * Il metodo inizializza gli elementi dell'interfaccia utente e 
     * prepara la logica per le azioni relative 
     * alla gestione della lista dei prestiti.
     * 
     * @param[in] url Percorso del file FXML associato al controller.
     * @param[in] rb Collezione di risorse localizzate per l'applicazione.
     * 
     * @post Gli attributi non statici sono stati inizializzati.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loanBookTitleClm.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getLibro().getTitolo()));
        loanUserClm.setCellValueFactory(c -> new SimpleStringProperty(formatUser(c.getValue().getUtente())));
        dateLimitClm.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDataRestituzione().format(DTF)));

        LoanTable.setRowFactory(tv -> new TableRow<Prestito>() {
    
        @Override
        protected void updateItem(Prestito prestito, boolean empty) {
        super.updateItem(prestito, empty);

        if (prestito == null || empty) {
            setStyle("");
        } else {
            if (prestito.getDataRestituzione().isBefore(LocalDate.now())) {
                // Se è selezionata usa un rosso scuro, altrimenti rosso chiaro
                if (isSelected()) {
                     setStyle("-fx-control-inner-background: #cc0000; -fx-background-color: #cc0000;");
                } else {
                     setStyle("-fx-control-inner-background: #ffcccc; -fx-background-color: #ffcccc;");
                }
            } else {
                setStyle("");
                }   
            }
        }
    });
        
        SchermataPrincipaleController.Shared.refreshAll();
        LoanTable.setItems(SchermataPrincipaleController.Shared.prestitiObs);
    }

    @FXML
    private void rimuoviPrestitoBtn(ActionEvent event) {
        Prestito selezionato = LoanTable.getSelectionModel().getSelectedItem();
        if (selezionato == null) {
            SchermataPrincipaleController.showError("Rimozione prestito", "Seleziona un prestito dalla tabella.");
            return;
        }

        try {
            SchermataPrincipaleController.Shared.gestionePrestiti.registraRestituzione(selezionato);
            SchermataPrincipaleController.Shared.refreshAll();
            LoanTable.refresh();

            SchermataPrincipaleController.showInfo("Prestito rimosso", "Prestito restituito/rimosso correttamente.");
        } catch (RuntimeException ex) {
            SchermataPrincipaleController.showError("Rimozione prestito non riuscita", ex.getMessage());
        }
    }

    private static String formatUser(Utente u) {
        if (u == null) return "";
        return safe(u.getCognome()) + " " + safe(u.getNome()) + " (" + safe(u.getMatricola()) + ")";
    }

    private static String safe(String s) {
        return s == null ? "" : s.trim();
    }
}
