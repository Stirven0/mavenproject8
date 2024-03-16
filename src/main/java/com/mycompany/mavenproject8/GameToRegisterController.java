/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author julio
 */
public class GameToRegisterController implements Initializable {

    
    private fxmlLoader loader = new fxmlLoader();
    private Parent game;
    
    
    @FXML
    private BorderPane brPanel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = loader.getParent("game");
        brPanel.setCenter(game);
        
    }    
    @FXML
    void cerrar(MouseEvent event) {
        System.exit(0);
    }
    
}
