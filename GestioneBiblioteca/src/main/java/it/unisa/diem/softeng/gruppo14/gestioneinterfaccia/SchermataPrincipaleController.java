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
import javafx.scene.control.MenuItem;

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

    @FXML
    private MenuItem salvaBtn;

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
        // TODO
    }    

    @FXML
    private void salvaArchivio(ActionEvent event) {
    }
    
}
