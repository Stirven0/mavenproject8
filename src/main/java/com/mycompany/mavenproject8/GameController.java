/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject8;

import com.jfoenix.controls.JFXButton;
import com.mycompany.mavenproject8.Oters.Payer;
import java.io.File;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Shape3D;
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
    private final String carpetaImagenes = getClass().getResource("/Imagenes/imgGame").toExternalForm();
    private static List<Image> listaImages;
    private static List<PhongMaterial> listMaterials;

    @FXML
    private Box myBox;

    @FXML
    private Box myBox1;

    @FXML
    private Box myBox10;

    @FXML
    private Box myBox11;

    @FXML
    private Box myBox12;

    @FXML
    private Box myBox13;

    @FXML
    private Box myBox14;

    @FXML
    private Box myBox15;

    @FXML
    private Box myBox2;

    @FXML
    private Box myBox3;

    @FXML
    private Box myBox4;

    @FXML
    private Box myBox5;

    @FXML
    private Box myBox6;

    @FXML
    private Box myBox7;

    @FXML
    private Box myBox8;

    @FXML
    private Box myBox9;

    private double duration = .5/2;
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

        Image imagen = new Image("Imagenes/imgGame/car.png");

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(imagen);

//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.ZERO, new KeyValue(((Shape3D) event.getSource()).materialProperty(), ((Shape3D) event.getSource()).getMaterial())),
//                new KeyFrame(new Duration(1000), new KeyValue(((Shape3D) event.getSource()).materialProperty(), material, Interpolator.LINEAR)));
//        timeline.setAutoReverse(true);
//        timeline.play();
        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.seconds(duration));
        rotate.setNode((Box) event.getSource());
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(90);
        rotate.setOnFinished(evento -> {
            ((Shape3D) event.getSource()).setMaterial(material);
            RotateTransition rotate1 = new RotateTransition();
            rotate1.setDuration(Duration.seconds(duration));
            rotate1.setNode((Box) event.getSource());
            rotate1.setAxis(Rotate.Y_AXIS);
            rotate1.setByAngle(90);
            rotate1.play();
        });
        rotate.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // // TODO
        payer = PrimaryController.getPayerselected();
        namePlayer.setText(payer.getUsuario());
        updatePuntosPlayer(0);
        updatePuntosinvitado(0);
//        cargarImgs();
//        cargarMateriales();
//        
        
    }

    private void cargarMateriales() {
        for (Image image : listaImages) {
            PhongMaterial material = new PhongMaterial();
            material.setDiffuseMap(image);
            listMaterials.add(material);
        }
    }

    private void cargarImgs() {
        File carpeta = new File(carpetaImagenes);
        if(carpeta.exists() && carpeta.isDirectory()){
            File[] imagenes = carpeta.listFiles((dir, name) ->
                    name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png"));
            System.out.println("la cantidad de imagenens dentro de la carpeta es "+imagenes.length);
            for (File imagen : imagenes) {
                listaImages.add(new Image(imagen.toURI().toString()));
            }
        } else {
            System.out.println("La carpeta no existe o no es una carpeta válida.");
        }
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
        nameInvitado.setVisible(false);
        puntosInvitado.setVisible(false);
        showGame();
    }

    @FXML
    void twoPlayerMouseClicked(MouseEvent event) {
        showGame();
    }

    public void showGame() {
        // for (int i = 100; i > 0; i--) {

        // selectedPlayers.setOpacity(i * 0.01);
        // try {
        // Thread.sleep(30);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
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
