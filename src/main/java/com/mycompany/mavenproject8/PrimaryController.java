package com.mycompany.mavenproject8;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class PrimaryController implements Initializable  {
    private Alert alerta;
    static Conection con;
    static Connection cn;
    private String[] listaPreguntas = {"Nombre de la Primera Mascota?","Cual es su Comida Favorita?","Marca del Telefono Anterior?"};

    //Conponentes del FXML
    @FXML
    private PasswordField regContrasena;

    @FXML
    private TextField regNombreUsuario;

    @FXML
    private ComboBox<?> regPregunta;

    @FXML
    private PasswordField regRespuesta;

    @FXML
    private PasswordField iniContrasena;

    @FXML
    private TextField iniNombreUsuario;

    @FXML
    private Button panelBtnCrear;

    @FXML
    private Label crearCuentaText;

    @FXML
    private AnchorPane panelCrearCuenta;

    //Accioness De Los Componentes
    @FXML
    void mover() throws IOException {
        TranslateTransition slider = new TranslateTransition();
        if (panelCrearCuenta.getTranslateX() == 0) {
            slider.setNode(panelCrearCuenta);
            slider.setToX(320);
            slider.setDuration(Duration.seconds(.5));
            slider.play();
            crearCuentaText.setText("Tienes una cuenta?");
            panelBtnCrear.setText("Iniciar Secion");
        }
        if (panelCrearCuenta.getTranslateX() == 320) {
            slider.setNode(panelCrearCuenta);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));
            slider.play();
            crearCuentaText.setText("No tienes una cuenta");
            panelBtnCrear.setText("Crear Cuenta");
        }
    }

    @FXML
    void iniBtn() throws IOException {
        if (iniNombreUsuario.getText().isEmpty() || iniContrasena.getText().isEmpty()) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensage de Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Introdusca su Usuario y/o Contaseña");
            alerta.showAndWait();

        }else{
//            ParejasApplication.setRoot("adminpanel");
        }

    }

    @FXML
    void regBtn() {
        // if (regNombreUsuario.getText().isEmpty() || regContrasena.getText().isEmpty() || regRespuesta.getText().isEmpty() || regPregunta.) {
        //     alerta = new Alert(AlertType.ERROR);
        //     alerta.setTitle("Mensage de Error");
        //     alerta.setHeaderText(null);
        //     alerta.setContentText("Introdusca su Usuario y/o Contaseña");
        //     alerta.showAndWait();

        // }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        con = new Conection();
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
        cn = con.conexion();
        if(con.conected){
            System.out.println("Conneccion con el sevidor activa");
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensage de Error");
            alerta.setHeaderText(null);
            alerta.setContentText("No fue posible conectar con la base de datos \nSe prosede a trabajar en local");
            alerta.showAndWait();
        }
    }
}
