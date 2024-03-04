package com.mycompany.mavenproject8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import com.jfoenix.controls.JFXButton;
import com.mycompany.mavenproject8.lista.Nodo;

import javafx.scene.control.ScrollPane;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class SecondaryController {

    double x;
    double y;
    @FXML
    private AnchorPane panelSuperior;
    @FXML
    private JFXButton btnRestore;

    @FXML
    private JFXButton btnAgegar;

    @FXML
    private JFXButton dashboart;

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
        if (menu.getTranslateX() == 0) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(time), menu);
            transition.setToX(-176);
            transition.play();
        }
        if (menu.getTranslateX() == -176) {
            TranslateTransition transition = new TranslateTransition(Duration.seconds(time), menu);
            transition.setToX(-0);
            transition.play();
        }

    }

    @FXML
    void salir(MouseEvent event) throws IOException {

        /*
         * if(loguinController.con.conected){
         * loguinController.con.desconeccion();
         * }
         */
        // ParejasApplication.setRoot("loguin");
    }

    @FXML
    void setGame(ActionEvent event) {
        fxmlLoader loader = new fxmlLoader();
        Parent view = loader.getParent("game");
        System.out.println("set game panel");
        // view.setScaleX(.5);
        // view.setScaleY(.5);
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

    @FXML
    void getDashboart(ActionEvent event) {

        fxmlLoader loader = new fxmlLoader();
        Parent view = loader.getParent("tabla");
        System.out.println("set tabla panel");
        // view.setScaleX(.5);
        // view.setScaleY(.5);
        brPanel.setCenter(view);
    }

    @FXML
    void setAgregarForm(ActionEvent event) {
        fxmlLoader loader = new fxmlLoader();
        Parent view = loader.getParent("ReguisterAdmin");
        System.out.println("set ReguisterAdmin panel");
        // view.setScaleX(.5);
        // view.setScaleY(.5);
        brPanel.setCenter(view);
    }

    @FXML
    void backUo(ActionEvent event) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar en");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Archivo de Texto", "*.txt"),
                new ExtensionFilter("Todos los Archivos", "*.*"));
        fileChooser.setInitialFileName("julio");
        File archivoGuardado = fileChooser.showSaveDialog(null);
        FileWriter writer = new FileWriter(archivoGuardado);
        writer.write("hola mundo");
        writer.close();

    }

    @FXML
    void restore(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo");

        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Archivo de Texto", "*.txt"),
                new ExtensionFilter("Todos los Archivos", "*.*"));
        File restore = fileChooser.showOpenDialog(null);
        try (BufferedReader br = new BufferedReader(new FileReader(restore))) {
            StringBuilder sBuilder = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                sBuilder.append(linea).append("\n");
            }
            String contenido = sBuilder.toString();
            System.out.println("Contenido del Archivo:\n" + contenido);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    void mouseDrage(MouseEvent event) {
        Stage stage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);
    }

    @FXML
    void mousePresed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

}
