package com.mycompany.mavenproject8;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.ScrollPane;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class SecondaryController {

    
    @FXML
    private ScrollPane scrolGame;
    
    @FXML
    private AnchorPane gamePanel;
    
    @FXML
    private ImageView cerrar;


    @FXML
    private BorderPane brPanel;

    @FXML
    void cerrar(MouseEvent event) {
        System.exit(0);
    }
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    private JFXButton btnSalir;
    @FXML
    private AnchorPane menu;
    @FXML
    void menuEvent(MouseEvent event) {


        double time = .5;
        if (menu.getTranslateX()==0){
            TranslateTransition transition = new TranslateTransition(Duration.seconds(time),menu);
            transition.setToX(-176);
            transition.play();
        }
        if (menu.getTranslateX()==-176){
            TranslateTransition transition = new TranslateTransition(Duration.seconds(time),menu);
            transition.setToX(-0);
            transition.play();
        }

    }
    @FXML
    void salir(MouseEvent event) throws IOException {


        /*if(loguinController.con.conected){
            loguinController.con.desconeccion();
        }*/
        //ParejasApplication.setRoot("loguin");
    }

    @FXML
    void setGame(ActionEvent event) {
        fxmlLoader loader = new fxmlLoader();
        Parent view = loader.getParent("game");
        System.out.println("set game panel");
//        view.setScaleX(.5);
//        view.setScaleY(.5);
        brPanel.setCenter(view);

    }
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    void getTabla(ActionEvent event) {
        System.out.println("obteniendo la tabla");   
    }
}