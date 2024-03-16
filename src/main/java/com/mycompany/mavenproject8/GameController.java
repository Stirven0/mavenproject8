/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject8;

import com.jfoenix.controls.JFXButton;
import com.mycompany.mavenproject8.Oters.Payer;
import java.io.File;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author julio
 */
public class GameController implements Initializable {

    
    private static Payer payer;
    private final String defaultResour = getClass().getResource("").getPath();
    private final String carpetaImagenes = defaultResour + "imgGame/images";
    private static List<Image> listaImages = new ArrayList<>();
    private static List<PhongMaterial> listMaterials = new ArrayList<>();
    private Box boxAux;
    private Box boxAux2;
    private double durationAnimation = 0.2;
    private int boxCouter;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boxCouter = 0;
        payer = PrimaryController.getPayerselected();
        namePlayer.setText(payer.getUsuario());
        updatePuntosPlayer(0);
        updatePuntosinvitado(0);
        cargarImgs();
        cargarMateriales();
        setDefaulMaterial();

    }

    public void boxDisable(boolean Disable) {
        myBox.setDisable(Disable);
        myBox1.setDisable(Disable);
        myBox2.setDisable(Disable);
        myBox3.setDisable(Disable);
        myBox4.setDisable(Disable);
        myBox5.setDisable(Disable);
        myBox6.setDisable(Disable);
        myBox7.setDisable(Disable);
        myBox8.setDisable(Disable);
        myBox9.setDisable(Disable);
        myBox10.setDisable(Disable);
        myBox11.setDisable(Disable);
        myBox12.setDisable(Disable);
        myBox13.setDisable(Disable);
        myBox14.setDisable(Disable);
        myBox15.setDisable(Disable);
    }

    private void comparador() {

        // rotation1(boxAux2);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                Material m1 = boxAux.getMaterial();
                Material m2 = boxAux2.getMaterial();

                if (m1.equals(m2)) {
                    System.out.println("los materiales son iguales");
                    updatePuntosPlayer(payer.getPuntaje() + 1);
                    boxAux2.setDisable(true);
                    boxAux.setDisable(true);

                    boxAux = null;
                } else {

                    rotation11(boxAux2);
                    rotation11(boxAux);
                    boxAux.setDisable(false);
                    boxAux2.setDisable(false);
                    boxAux = null;
                    System.out.println("los materiales son diferentes");

                }
                boxCouter=0;

            }

        };
        timer.schedule(task, 1000);
    }

    public void rotation1(Box box) {
        boxDisable(true);
        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.seconds(durationAnimation));
        rotate.setNode(box);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(90);
        rotate.setOnFinished(evento -> {

            setMaterilBox(box);
            rotation2(box);

        });
        rotate.play();
    }

    public void rotation11(Box box) {
        boxDisable(true);
        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.seconds(durationAnimation));
        rotate.setNode(box);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(90);
        rotate.setOnFinished(evento -> {

            setDefaulMaterial(box);
            rotation2(box);

        });
        rotate.play();

    }

    public void rotation2(Box box) {

        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.seconds(durationAnimation));
        rotate.setNode(box);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(90);
        rotate.setOnFinished(evento -> {

            boxDisable(false);

        });
        rotate.play();

    }

    public void setMaterilBox(Box box) {
        switch (box.getId()) {
            case "myBox":
                box.setMaterial(listMaterials.get(0));
                break;

            case "myBox1":
                box.setMaterial(listMaterials.get(1));
                break;

            case "myBox2":
                box.setMaterial(listMaterials.get(2));
                break;

            case "myBox3":
                box.setMaterial(listMaterials.get(3));
                break;

            case "myBox4":
                box.setMaterial(listMaterials.get(4));
                break;

            case "myBox5":
                box.setMaterial(listMaterials.get(5));
                break;

            case "myBox6":
                box.setMaterial(listMaterials.get(6));
                break;

            case "myBox7":
                box.setMaterial(listMaterials.get(7));
                break;

            case "myBox8":
                box.setMaterial(listMaterials.get(8));
                break;

            case "myBox9":
                box.setMaterial(listMaterials.get(9));
                break;

            case "myBox10":
                box.setMaterial(listMaterials.get(10));
                break;

            case "myBox11":
                box.setMaterial(listMaterials.get(11));
                break;

            case "myBox12":
                box.setMaterial(listMaterials.get(12));
                break;

            case "myBox13":
                box.setMaterial(listMaterials.get(13));
                break;

            case "myBox14":
                box.setMaterial(listMaterials.get(14));
                break;

            case "myBox15":
                box.setMaterial(listMaterials.get(15));
                break;

            default:
                break;
        }

    }

    public void setDefaulMaterial(Box box) {

        PhongMaterial material = new PhongMaterial();
        Image img = new Image(getClass().getResource("imgGame/pregunta.png").toExternalForm());
        material.setDiffuseMap(img);
        box.setMaterial(material);

    }

    private void setDefaulMaterial() {
        try {

            PhongMaterial material = new PhongMaterial();
            Image img = new Image(getClass().getResource("imgGame/pregunta.png").toExternalForm());
            material.setDiffuseMap(img);
            myBox.setMaterial(material);
            myBox1.setMaterial(material);
            myBox2.setMaterial(material);
            myBox3.setMaterial(material);
            myBox4.setMaterial(material);
            myBox5.setMaterial(material);
            myBox6.setMaterial(material);
            myBox7.setMaterial(material);
            myBox8.setMaterial(material);
            myBox9.setMaterial(material);
            myBox10.setMaterial(material);
            myBox11.setMaterial(material);
            myBox12.setMaterial(material);
            myBox13.setMaterial(material);
            myBox14.setMaterial(material);
            myBox15.setMaterial(material);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarMateriales() {
        try {
            for (Image image : listaImages) {
                PhongMaterial material = new PhongMaterial();
                material.setDiffuseMap(image);
                listMaterials.add(material);
                listMaterials.add(material);
            }

            Collections.shuffle(listMaterials);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void cargarImgs() {
        try {
            File carpeta = new File(carpetaImagenes);
            // System.out.println(carpetaImagenes);
            // System.out.println(carpeta.exists());
            if (carpeta.exists() && carpeta.isDirectory()) {
                File[] imagenes = carpeta.listFiles(
                        (dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png"));
                System.out.println("la cantidad de imagenens dentro de la carpeta es " + imagenes.length);
                for (File imagen : imagenes) {
                    listaImages.add(new Image(imagen.toURI().toString()));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showGame() {
        selectedPlayers.setVisible(false);
    }

    public void updatePuntosPlayer(int puntos) {
        payer.setPuntaje(puntos);
        String str = Integer.toString(puntos);
        Platform.runLater(() -> puntosPlayer.setText(str));
    }

    public void updatePuntosinvitado(int puntosInvitado) {
        this.puntosInvitado.setText(Integer.toString(puntosInvitado));
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

    @FXML
    void salir_del_panel(ActionEvent event) {
        System.out.println("oter panel");
    }

    @FXML
    protected void rotar(MouseEvent event) {

        if (boxCouter < 2) {

            if (boxAux == null) {
                boxAux = ((Box) event.getSource());
                boxAux.setDisable(true);
                rotation1(((Box) event.getSource()));
                boxCouter = boxCouter + 1;

            } else {

                boxCouter = boxCouter + 1;
                boxAux2 = ((Box) event.getSource());
                rotation1(boxAux2);

                comparador();

            }
        }

    }

}
