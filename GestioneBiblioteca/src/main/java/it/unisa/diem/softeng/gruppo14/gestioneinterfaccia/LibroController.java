/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.gruppo14.gestioneinterfaccia;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * @brief Classe che gestisce l'interfaccia di visualizzazione dei libri presenti nell'archivio.
 * 
 * La classe gestisce le azioni relative alla visualizzazione e manipolazione
 * dei dati dei libri, come l'aggiunta, la modifica e la rimozione 
 * dei libri nella tabella.
 *
 * @author gruppo 14
 */
public class LibroController implements Initializable {

    @FXML
    private TableView<?> bookTable1;
    @FXML
    private TableColumn<?, ?> titleClm1;
    @FXML
    private TableColumn<?, ?> authorClm1;
    @FXML
    private TableColumn<?, ?> pubYearClm1;
    @FXML
    private TableColumn<?, ?> isbnClm1;
    @FXML
    private TableColumn<?, ?> numCopiesClm1;
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField pubYearField;
    @FXML
    private TextField isbnField;
    @FXML
    private TextField numCopiesField;
    @FXML
    private AnchorPane gestioneLibriPane;
    @FXML
    private TextField bookSearchField;
    @FXML
    private Button aggiungiLBtn;
    @FXML
    private Button modificaLBtn;
    @FXML
    private Button rimuoviLBtn;

    /**
     * @brief Inizializza il controller.
     * 
     * Il metodo inizializza gli elementi dell'interfaccia utente e 
     * prepara la logica per le azioni dell'utente 
     * 
     * @param[in] url Percorso del file FXML associato al controller.
     * @param[in] rb Collezione di risorse localizzate per l'applicazione.
     * 
     * @post Gli attributi non statici sono stati inizializzati.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }    

    @FXML
    private void aggiungiLibroBtn(ActionEvent event) {
    }

    @FXML
    private void modificaLibroBtn(ActionEvent event) {
    }

    @FXML
    private void rimuoviLibroBtn(ActionEvent event) {
    }
    
}
