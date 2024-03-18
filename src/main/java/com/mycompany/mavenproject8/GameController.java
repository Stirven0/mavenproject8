/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject8;

import com.jfoenix.controls.JFXButton;
import com.mycompany.mavenproject8.Oters.Player;
import java.io.File;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
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

    private static Player player;
    private static Player playerInivitado;
    private static Player playerSelec;

    private final String defaultResour = getClass().getResource("").getPath();
    private final String carpetaImagenes = defaultResour + "imgGame/images";
    private static List<Image> listaImages = new ArrayList<>();
    private static List<PhongMaterial> listMaterials = new ArrayList<>();
    private List<Box> allBox = new ArrayList<>();
    private Box boxAux;
    private Box boxAux2;
    private double durationAnimation = 0.2;
    private int boxCouter;

    private int timerReset = 10;
    private int timerCounter;

    @FXML
    private Label lbTimer;

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
        player = PrimaryController.getPlayerselected();
        playerInivitado = new Player();
        playerSelector(player);
        boxCouter = 0;

        timerCounter = timerReset;
        namePlayer.setText(player.getUsuario());
        updatePuntosPlayer(0);
        updatePuntosinvitado(0);
        cargarImgs();
        cargarMateriales();
        setDefaulMaterial();
        addBoxToList();

    }

    public void addBoxToList() {
        allBox.add(myBox);
        allBox.add(myBox1);
        allBox.add(myBox2);
        allBox.add(myBox3);
        allBox.add(myBox4);
        allBox.add(myBox5);
        allBox.add(myBox6);
        allBox.add(myBox7);
        allBox.add(myBox8);
        allBox.add(myBox9);
        allBox.add(myBox10);
        allBox.add(myBox11);
        allBox.add(myBox12);
        allBox.add(myBox13);
        allBox.add(myBox14);
        allBox.add(myBox15);
    }

    public void boxDisable(boolean Disable) {
        for (Box box : allBox) {
            box.setDisable(Disable);
        }
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
                    updatePuntos(1);
                    boxAux2.setDisable(true);
                    boxAux.setDisable(true);

                    timerCounter = timerReset;
                    boxAux = null;
                } else {

                    rotation11(boxAux2);
                    rotation11(boxAux);
                    boxAux.setDisable(false);
                    boxAux2.setDisable(false);
                    boxAux = null;
                    System.out.println("los materiales son diferentes");

                }
                boxCouter = 0;

            }

        };
        timer.schedule(task, 1000);
    }

    public void updatePuntos(int puntos) {
        if (playerSelec == player) {
            updatePuntosPlayer(player.getPuntaje() + puntos);
        }
        if (playerSelec == playerInivitado) {
            updatePuntosinvitado(playerInivitado.getPuntaje() + puntos);
        }
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

    public boolean totalPuntosAlcansados() {
        int totalPuntos = player.getPuntaje()+playerInivitado.getPuntaje();
        return totalPuntos>=8?true:false;

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

    public void showGame(boolean twoPlayer) {

        // lbTimer;
        Timeline cuentaRegresiva = new Timeline();
        cuentaRegresiva.setCycleCount(Timeline.INDEFINITE);
        final KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                timerCounter--;
                lbTimer.setText(Integer.toString(timerCounter));

                if (twoPlayer) {
                    if (totalPuntosAlcansados()) {
                        System.out.println("Player: " + playerSelec.getUsuario() + " Es el ganador");
                        boxDisable(true);
                        cuentaRegresiva.stop();
                    }

                    if (timerCounter <= 0) {
                        if (playerSelec == player) {
                            playerSelector(playerInivitado);
                        } else {
                            playerSelector(player);
                        }
                        timerCounter = timerReset;

                    }
                } else {
                    if (timerCounter <= 0) {
                        boxDisable(true);
                        cuentaRegresiva.stop();

                        if (totalPuntosAlcansados()) {
                            System.out.println("Lo has destapado todo");
                        } else {
                            System.out.println("No has podido destapar todo ");
                        }

                        System.out.println("se acabo el tiempo");

                    }
                }

            }

        });
        cuentaRegresiva.getKeyFrames().add(frame);
        cuentaRegresiva.playFromStart();

        selectedPlayers.setVisible(false);
    }

    public void playerSelector(Player p) {
        playerSelec = p;

        if (playerSelec == player) {

            nameInvitado.setScaleX(1);
            nameInvitado.setScaleY(1);
            namePlayer.setScaleX(2);
            namePlayer.setScaleY(2);
        } else {
            nameInvitado.setScaleX(2);
            nameInvitado.setScaleY(2);

            namePlayer.setScaleX(1);
            namePlayer.setScaleY(1);
        }

    }

    public boolean confirmación(String mensage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(mensage);
        alert.setContentText("Elige tu opción.");

        ButtonType buttonTypeYes = new ButtonType("Sí", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes) {
            return true;
        } else {
            return false;
        }
    }

    public void updatePuntosPlayer(int puntos) {
        player.setPuntaje(puntos);
        String str = Integer.toString(puntos);
        Platform.runLater(() -> puntosPlayer.setText(str));
    }

    public void updatePuntosinvitado(int puntosInvitado) {

        playerInivitado.setPuntaje(puntosInvitado);
        Platform.runLater(() -> this.puntosInvitado.setText(Integer.toString(puntosInvitado)));
    }

    @FXML
    void singelPlayer(MouseEvent event) {
        pnelIN.setVisible(false);
    }

    @FXML
    void twoPlayer(MouseEvent event) {

        pnelIN.setVisible(false);
    }
//
//    @FXML
//    void singelPlayyerMouseEntered(MouseEvent event) {
//        singelPlayyer.setStyle("-fx-background-color: #90EE90;");
//
//    }
//
//    @FXML
//    void twoPlayerMouseEnterred(MouseEvent event) {
//        twoPlayer.setStyle("-fx-background-color: #90EE90;");
//
//    }
//
//    @FXML
//    void singelPlayerMouseExite(MouseEvent event) {
//
//        singelPlayyer.setStyle("-fx-background-color: #ffffff;");
//    }
//
//    @FXML
//    void twoPlayerMouseExite(MouseEvent event) {
//
//        twoPlayer.setStyle("-fx-background-color: #ffffff;");
//    }

    @FXML
    void singelPlayyerMouseClicked(MouseEvent event) {
        nameInvitado.setVisible(false);
        puntosInvitado.setVisible(false);
        showGame(false);
    }

    @FXML
    void twoPlayerMouseClicked(MouseEvent event) {
        showGame(true);
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
