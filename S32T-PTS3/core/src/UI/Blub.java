/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.badlogic.gdx.ApplicationAdapter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Milton van de Sanden
 */
public class Blub extends Application
{    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            StackPane page = (StackPane) FXMLLoader.load(Blub.class.getResource("LogInFXML.fxml"));
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("FXML is Simple");
            primaryStage.show();
        } catch (IOException ex)
        {
            Logger.getLogger(Blub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
