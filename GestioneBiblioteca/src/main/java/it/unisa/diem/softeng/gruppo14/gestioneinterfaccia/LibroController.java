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
    private Button addBookButton;
    @FXML
    private Button modifyBookButton;
    @FXML
    private Button removeBookButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aggiungiLibro(ActionEvent event) {
    }

    @FXML
    private void modificaLibro(ActionEvent event) {
    }

    @FXML
    private void rimuoviLibro(ActionEvent event) {
    }
    
}
