/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject8;

import com.jfoenix.controls.JFXButton;
import com.mycompany.mavenproject8.Oters.Payer;

import java.net.URL;
import java.security.Principal;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author julio
 */
public class GameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private static Payer payer;
    
    
    
    @FXML
    private Label puntosInvitado;
    @FXML
    private Label nameInvitado;
    @FXML
    private Label namePlayer;

    @FXML
    private Label puntosPlayer;

    @FXML
    private Group selectedPlayers;

    @FXML
    private Group game;
    @FXML
    private Pane singelPlayyer;

    @FXML
    private Pane twoPlayer;

    @FXML
    private Pane pnelIN;

    @FXML
    private Label singel;

    @FXML
    private Label two;
    @FXML
    private JFXButton btnBack;

    private int puntosp;
    private int puntosinv;

    @FXML
    void salir_del_panel(ActionEvent event) {
        System.out.println("oter panel");
    }

    @FXML
    protected void rotar(MouseEvent event) {
        double duration = .5;
        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.seconds(duration));
        rotate.setNode((Box) event.getSource());
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(180);
        rotate.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // // TODO
        payer = PrimaryController.getPayer();
        namePlayer.setText(payer.getUsuario());
        updatePuntosPlayer(0);
        updatePuntosinvitado(0);
    }

    @FXML
    void singelPlayer(MouseEvent event) {
        pnelIN.setVisible(false);
    }

    @FXML
    void twoPlayer(MouseEvent event) {

        pnelIN.setVisible(false);
    }

    @FXML
    void singelPlayyerMouseEntered(MouseEvent event) {
        singelPlayyer.setStyle("-fx-background-color: #90EE90;");

    }

    @FXML
    void twoPlayerMouseEnterred(MouseEvent event) {
        twoPlayer.setStyle("-fx-background-color: #90EE90;");

    }

    @FXML
    void singelPlayerMouseExite(MouseEvent event) {

        singelPlayyer.setStyle("-fx-background-color: #ffffff;");
    }

    @FXML
    void twoPlayerMouseExite(MouseEvent event) {

        twoPlayer.setStyle("-fx-background-color: #ffffff;");
    }

    @FXML
    void singelPlayyerMouseClicked(MouseEvent event) {
        showGame();
    }

    @FXML
    void twoPlayerMouseClicked(MouseEvent event) {
        showGame();
    }

    public void showGame() {
        // for (int i = 100; i > 0; i--) {

        //     selectedPlayers.setOpacity(i * 0.01);
        //     try {
        //         Thread.sleep(30);
        //     } catch (InterruptedException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }

        // }
            selectedPlayers.setVisible(false);
    }
    public void updatePuntosPlayer(int puntos) {
        puntosp = puntos;
        puntosPlayer.setText(Integer.toString(puntos));
    }
    public void updatePuntosinvitado(int puntosInvitado) {
        this.puntosInvitado.setText(Integer.toString(puntosInvitado));
        puntosinv = puntosInvitado;
    }

}
