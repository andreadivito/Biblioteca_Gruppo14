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
    private Button addLoanButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aggiungiPrestito(ActionEvent event) {
    }
    
}
