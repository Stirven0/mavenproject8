package com.mycompany.mavenproject8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import com.mycompany.mavenproject8.Oters.Payer;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;

public class SecondaryController implements Initializable {

    double x;
    double y;
    private fxmlLoader loader = new fxmlLoader();
    private Parent tabla;
    private Parent reguisterAdmin;
    private Parent game;

    private static Payer payer = PrimaryController.getPayerselected();

    public static Payer getPayer() {
        return payer;
    }

    @FXML
    private JFXButton btnBckUp;
    @FXML
    private JFXButton eliminar;
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
    private JFXButton btnSalir;

    @FXML
    private AnchorPane menu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tabla = loader.getParent("tabla");
        reguisterAdmin = loader.getParent("ReguisterAdmin");
        game = loader.getParent("game");

        
        brPanel.setCenter(tabla);
    }

    @FXML
    void cerrar(MouseEvent event) {
        System.exit(0);
    }

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
    void setGame(ActionEvent event) {
        System.out.println("set game panel");
        brPanel.setCenter(game);

    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void getDashboart(ActionEvent event) {
        System.out.println("set tabla panel");
        brPanel.setCenter(tabla);
    }

    @FXML
    void setAgregarForm(ActionEvent event) {
        System.out.println("set ReguisterAdmin panel");
        brPanel.setCenter(reguisterAdmin);
    }

    @FXML
    void backUp(ActionEvent event) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar en");
        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Archivo de Texto", "*.txt"),
                new ExtensionFilter("Todos los Archivos", "*.*"));
        fileChooser.setInitialFileName(payer.getUsuario());
        File archivoGuardado = fileChooser.showSaveDialog(btnBckUp.getScene().getWindow());

        String usuario = payer.getUsuario();
        String contrasena = payer.getContrasena();
        String pregunta = payer.getPregunta();
        String respuesta = payer.getRespuesta();
        String tiempoJuego = payer.getTiempoGuego().toString();
        int puntaje = payer.getPuntaje();
        int turnos = payer.getTurnos();
        int admin = payer.isAdmin();
        
        FileWriter writer = new FileWriter(archivoGuardado);
        writer.write(usuario+";"+
                    contrasena+";"+
                    pregunta+";"+
                    respuesta+";"+
                    tiempoJuego+";"+
                    puntaje+";"+
                    turnos+";"+
                    admin);
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
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    void mousePresed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    void delete(ActionEvent event) {
        int id = TablaController.getID();
        if (id != 0) {

            try {
                PreparedStatement ps = PrimaryController.getCn()
                        .prepareStatement("DELETE FROM data WHERE id='" + Integer.toString(id) + "'");
                int Result = ps.executeUpdate();
                if (Result > 0) {
                    fxmlLoader loader = new fxmlLoader();
                    Parent view = loader.getParent("tabla");
                    brPanel.setCenter(view);
                    System.out.println("set tabla panel");

                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Mensage de Error");
                    alerta.setHeaderText(null);
                    alerta.setContentText("No fue posible Borrar el Usuario");
                    alerta.showAndWait();
                }
            } catch (SQLException e) {
                System.err.println("Error al elimiar " + e);
            }
        }

        System.out.println("deleter user");

    }

}
