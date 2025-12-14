package it.unisa.diem.softeng.gruppo14.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @brief Classe principale per l'applicazione JavaFX.
 * 
 * La classe avvia l'applicazione JavaFX fornendo il metodo necessario
 * all'avvio della scena. 
 * 
 * @author gruppo14
 */
public class Main extends Application {

    private static Scene scene;
    /**
     * @brief Metodo principale per l'avvio dell'applicazione.
     * 
     * @param[in] args Argomenti dalla linea di comando.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    /** 
     * @brief Metodo di avvio dell'applicazione JavaFX.
     * 
     * Il metodo imposta la scena principale e la mostra
     * 
     * @param[in] primaryStage Lo stage principale dell'applicazione.
     * @throws IOException Nel caso in cui il file FXML specificato non può essere caricato.
     */
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unisa/diem/softeng/gruppo14/interfacciagrafica/SchermataPrincipale.fxml"));
        
        Parent root = loader.load();

        scene = new Scene(root, 900, 650);
        
        primaryStage.setTitle("Archivio Biblioteca");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
}
