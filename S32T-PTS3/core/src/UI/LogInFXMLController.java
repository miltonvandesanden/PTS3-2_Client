/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Game.ClientManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Herman
 */
public class LogInFXMLController implements Initializable {

    @FXML
    private TextField tfUserName;
    @FXML
    private Button btnJoinLobby;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void JoinLobby(ActionEvent event) {
        String UserName = tfUserName.getText();
        ClientManager clientManager = new ClientManager();
        clientManager.logIn(UserName);
    }
    
}
