/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.Event;


/**
 *
 * @author Hruteesh Raja
 */

public class StartController implements Initializable {
    public Button squareBtn;
    public Button hexagonBtn;
    public Label title;
    
    public void squareClicked(ActionEvent event)  throws Exception{
        System.out.println("Square Tiling Selected.");
        Parent Square =  FXMLLoader.load(getClass().getResource("Square.fxml"));
        Scene SquareScene = new Scene(Square);
        Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(SquareScene);
        window.show();
        
        
    }
    
    public void hexagonClicked(ActionEvent event) throws Exception{
        System.out.println("Hexagon Tiling Selected");
        Parent Square =  FXMLLoader.load(getClass().getResource("Hexagon.fxml"));
        Scene SquareScene = new Scene(Square);
        Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(SquareScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
}
