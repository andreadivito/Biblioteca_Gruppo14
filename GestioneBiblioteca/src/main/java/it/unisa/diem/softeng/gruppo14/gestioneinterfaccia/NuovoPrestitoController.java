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
 * @brief Classe che gestisce l'interfaccia relativa all'aggiunta di un nuovo prestito.
 * 
 * La classe gestisce le azioni relative alla creazione di un nuovo prestito.
 * Permette di selezionare un libro, un utente e impostare la data 
 * di restituzione di un prestito.
 * 
 * @author gruppo14 
 */
public class NuovoPrestitoController implements Initializable {

    @FXML
    private TableView<?> userTable;
    @FXML
    private TableColumn<?, ?> surnameClm;
    @FXML
    private TableColumn<?, ?> nameClm;
    @FXML
    private TableColumn<?, ?> codeClm;
    @FXML
    private TableColumn<?, ?> mailClm;
    @FXML
    private TableView<?> bookTable;
    @FXML
    private TableColumn<?, ?> titleClm;
    @FXML
    private TableColumn<?, ?> authorClm;
    @FXML
    private TableColumn<?, ?> numCopiesClm;
    @FXML
    private TableColumn<?, ?> pubYearClm;
    @FXML
    private TableColumn<?, ?> isbnClm;
    @FXML
    private TextField dateLimitField;
    @FXML
    private AnchorPane nuovoPrestitoPane;
    @FXML
    private Button aggiungiPBtn;

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
        // TODO
    }    

    @FXML
    private void aggiungiPrestitoBtn(ActionEvent event) {
    }
    
}
