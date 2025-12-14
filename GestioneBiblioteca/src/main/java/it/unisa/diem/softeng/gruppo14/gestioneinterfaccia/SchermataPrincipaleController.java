package it.unisa.diem.softeng.gruppo14.gestioneinterfaccia;

import it.unisa.diem.softeng.gruppo14.gestionedati.Libro;
import it.unisa.diem.softeng.gruppo14.gestionedati.Prestito;
import it.unisa.diem.softeng.gruppo14.gestionedati.Utente;
import it.unisa.diem.softeng.gruppo14.gestionefile.FileManager;
import it.unisa.diem.softeng.gruppo14.gestionelogica.GestioneLibri;
import it.unisa.diem.softeng.gruppo14.gestionelogica.GestionePrestiti;
import it.unisa.diem.softeng.gruppo14.gestionelogica.GestioneUtenti;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * @brief Classe che gestisce l'interfaccia principale dell'applicazione.
 * 
 * La classe gestisce le azioni relative all'interfaccia principale 
 * dell'applicazione. Permette di interagire con le varie schermate
 * e di salvare l'archivio su un file.
 *
 * @author gruppo14
 */
public class SchermataPrincipaleController implements Initializable {

    @FXML private MenuItem salvaBtn;
    private static final String ARCHIVIO_PATH =
        System.getProperty("user.home") + java.io.File.separator + "archivio_biblioteca.dat";

    
    public static final class Shared {
        public static final GestioneLibri gestioneLibri = new GestioneLibri();
        public static final GestioneUtenti gestioneUtenti = new GestioneUtenti();
        public static final GestionePrestiti gestionePrestiti = new GestionePrestiti();
        public static final FileManager fileManager =
                new FileManager(gestioneLibri, gestioneUtenti, gestionePrestiti);

        public static final ObservableList<Libro> libriObs = FXCollections.observableArrayList();
        public static final ObservableList<Utente> utentiObs = FXCollections.observableArrayList();
        public static final ObservableList<Prestito> prestitiObs = FXCollections.observableArrayList();

        private Shared() {}

        public static void refreshAll() {
            libriObs.setAll(gestioneLibri.getLibri());
            utentiObs.setAll(gestioneUtenti.getUtenti());
            prestitiObs.setAll(gestionePrestiti.getPrestiti());
        }
    }

    /**
     * @brief Inizializza il controller.
     * 
     * Il metodo inizializza gli elementi dell'interfaccia utente e 
     * prepara la logica per le azioni relative 
     * alla gestione dell'intefaccia principale.
     * 
     * @param[in] url Percorso del file FXML associato al controller.
     * @param[in] rb Collezione di risorse localizzate per l'applicazione.
     * 
     * @post Gli attributi non statici sono stati inizializzati.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Shared.refreshAll();
        try {
            Shared.fileManager.caricaDaFile("archivio.dat");
            Shared.refreshAll();
        } catch (Exception ignored) {
        }
    }

    @FXML
    private void salvaArchivio(ActionEvent event) {
        Window owner = getWindowFromEvent(event);

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Salva archivio");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivio (.dat)", ".dat"));
        chooser.setInitialFileName("archivio.dat");

        java.io.File file = chooser.showSaveDialog(owner);
        if (file == null) return;

        try {
            Shared.fileManager.salvaSuFile(file.getAbsolutePath());
            showInfo("Salvataggio completato", "Archivio salvato in:\n" + file.getAbsolutePath());
        } catch (IOException ex) {
            showError("Errore salvataggio", ex.getMessage());
        } catch (RuntimeException ex) {
            showError("Errore salvataggio", ex.getMessage());
        }
    }

    public static void showError(String header, String content) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Errore");
        a.setHeaderText(header);
        a.setContentText(content == null ? "" : content);
        a.showAndWait();
    }

    public static void showInfo(String header, String content) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Info");
        a.setHeaderText(header);
        a.setContentText(content == null ? "" : content);
        a.showAndWait();
    }

    private static Window getWindowFromEvent(ActionEvent event) {
        if (event == null) return null;
        Object src = event.getSource();
        if (src instanceof Node) return ((Node) src).getScene().getWindow();
        return null;
  }
}
