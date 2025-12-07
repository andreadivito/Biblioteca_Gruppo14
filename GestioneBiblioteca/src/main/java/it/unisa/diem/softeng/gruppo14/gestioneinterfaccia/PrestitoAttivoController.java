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
import javafx.scene.layout.AnchorPane;

/**
 * @brief Classe che gestisce l'interfaccia dei prestiti attivi.
 * 
 * La classe gestisce le azioni relative alla visualizzazione e manipolazione 
 * dei prestiti attivi. Permette di vedere i prestiti in corso e rimuovere un prestito.
 * 
 * @author gruppo14 
 */
public class PrestitoAttivoController implements Initializable {

    @FXML
    private TableView<?> LoanTable;
    @FXML
    private TableColumn<?, ?> loanBookTitleClm;
    @FXML
    private TableColumn<?, ?> loanUserClm;
    @FXML
    private TableColumn<?, ?> dateLimitClm;
    @FXML
    private AnchorPane gestionePrestitiPane;
    @FXML
    private Button rimuoviPBtn;

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
        // TODO
    }    

    @FXML
    private void rimuoviPrestitoBtn(ActionEvent event) {
    }
    
}
