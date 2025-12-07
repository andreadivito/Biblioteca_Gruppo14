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
 * @brief Classe che gestisce l'interfaccia degli utenti presenti nell'archivio.
 * 
 * La classe gestisce le azioni relative alla visualizzazione e manipolazione
 * dei dati degli utenti, come l'aggiunta, la modifica e la rimozione 
 * degli utenti nella tabella.
 * 
 * @author gruppo14
 */
public class UtenteController implements Initializable {

    @FXML
    private TableView<?> userTable1;
    @FXML
    private TableColumn<?, ?> surnameClm1;
    @FXML
    private TableColumn<?, ?> nameClm1;
    @FXML
    private TableColumn<?, ?> codeClm1;
    @FXML
    private TableColumn<?, ?> mailClm1;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField codeField;
    @FXML
    private TextField mailField;
    @FXML
    private AnchorPane gestioneUtentiPane;
    @FXML
    private TextField userSearchField;
    @FXML
    private Button aggiungiUBtn;
    @FXML
    private Button modificaUBtn;
    @FXML
    private Button rimuoviUBtn;

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
        // TODO
    }    

    @FXML
    private void aggiungiUtenteBtn(ActionEvent event) {
    }

    @FXML
    private void modificaUtenteBtn(ActionEvent event) {
    }

    @FXML
    private void rimuoviUtenteBtn(ActionEvent event) {
    }
    
}
