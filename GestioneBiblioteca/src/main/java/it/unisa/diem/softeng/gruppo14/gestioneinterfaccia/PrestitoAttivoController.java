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
 * FXML Controller class
 *
 * @author gany
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
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void rimuoviPrestitoBtn(ActionEvent event) {
    }
    
}
