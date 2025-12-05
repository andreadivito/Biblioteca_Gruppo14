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

/**
 * FXML Controller class
 *
 * @author gany
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
    private Button addUserButton;
    @FXML
    private Button modifyUserButton;
    @FXML
    private Button removeUserButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aggiungiUtente(ActionEvent event) {
    }

    @FXML
    private void modificaUtente(ActionEvent event) {
    }

    @FXML
    private void rimuoviUtente(ActionEvent event) {
    }
    
}
