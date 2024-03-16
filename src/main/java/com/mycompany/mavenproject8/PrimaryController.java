package com.mycompany.mavenproject8;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import com.jfoenix.controls.JFXComboBox;
import com.mycompany.mavenproject8.Oters.Payer;
import com.mycompany.mavenproject8.lista.Lista;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class PrimaryController implements Initializable {

    private static java.sql.Statement statement;
    private static ResultSet rows;
    private static Lista playerList;

    private static Payer payerselected;

    public static Payer getPayerselected() {
        return payerselected;
    }

    static public Lista getPlayerList() {
        updateList();
        return playerList;
    }

    private Alert alerta;
    private static Conection con;
    private static Connection cn;

    public static Connection getCn() {
        return cn;
    }

    // static Conection con = new Conection();
    // static Connection cn = con.conexion();
    private String[] listaPreguntas = { "Nombre de la Primera Mascota?", "Cual es su Comida Favorita?",
            "Marca del Telefono Anterior?" };

    // Conponentes del FXML
    @FXML
    private PasswordField regContrasena;

    @FXML
    private TextField regNombreUsuario;

    @FXML
    private JFXComboBox<String> regPregunta;

    @FXML
    private TextField regRespuesta;

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

    // Accioness De Los Componentes
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            con = new Conection();
            playerList = new Lista();
            if (!con.conected) {
                cn = con.conexion();
                updateList();
            }

            if (con.conected) {
                System.out.println("Conneccion con el sevidor activa");
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensage de Error");
                alerta.setHeaderText(null);
                alerta.setContentText("No fue posible conectar con la base de datos \nSe prosede a trabajar en local");
                alerta.showAndWait();
            }

            regPregunta.getItems().addAll(listaPreguntas);
        } catch (Exception e) {
            System.out.println(e);
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {

                @Override
                public void run() {
                    moverPanel();
                    panelBtnCrear.setDisable(true);
                }

            };
            timer.schedule(task, 1000);
        }

        ////////////////////////////

    }

    private static void updateList() {
        playerList.clear();
        try {
            statement = cn.createStatement();
            rows = statement.executeQuery("SELECT * FROM data");

            while (rows.next()) {
                int iD = Integer.parseInt(rows.getString("id"));
                String usuario = rows.getString("usuario");
                String contrasena = rows.getString("contrasena");
                String pregunta = rows.getString("pregunta");
                String respuesta = rows.getString("respuesta");
                Time tiempoGuego = rows.getTime("tiempojugado");
                int puntaje = Integer.parseInt(rows.getString("puntaje"));
                int turnos = Integer.parseInt(rows.getString("turnos"));
                int admin = Integer.parseInt(rows.getString("admin"));

                Payer payer = new Payer(iD, usuario, contrasena, pregunta, respuesta, tiempoGuego, puntaje, turnos,
                        admin);
                playerList.add(payer);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void mover() throws IOException {
        moverPanel();
    }

    private void moverPanel() {
        TranslateTransition slider = new TranslateTransition();

        if (panelCrearCuenta.getTranslateX() == 0) {
            slider.setNode(panelCrearCuenta);
            slider.setToX(320);
            slider.setDuration(Duration.seconds(.5));
            slider.play();
            Platform.runLater(() -> crearCuentaText.setText("Tienes una cuenta?"));
            Platform.runLater(() -> panelBtnCrear.setText("Iniciar Secion"));
        }
        if (panelCrearCuenta.getTranslateX() == 320) {
            slider.setNode(panelCrearCuenta);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));
            slider.play();
            Platform.runLater(() ->crearCuentaText.setText("No tienes una cuenta"));
            Platform.runLater(() ->panelBtnCrear.setText("Crear Cuenta"));
        }

        limpiarFormularios();
    }

    @FXML
    void iniBtn() throws IOException {
        int j = 0;
        if (iniNombreUsuario.getText().isEmpty() || iniContrasena.getText().isEmpty()) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensage de Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Introdusca su Usuario y/o Contaseña");
            alerta.showAndWait();

        } else {
            while ((j++) < playerList.zise()) {
                Payer payeraux = playerList.get(j - 1);
                if (payeraux.getUsuario().equals(iniNombreUsuario.getText())
                        && payeraux.getContrasena().equals(iniContrasena.getText())) {
                    payerselected = payeraux;
                    System.out.println("user is logued");
                    limpiarFormularios();
                    App.setRoot("secondary");
                    break;
                }
            }

        }

        if (j > playerList.zise()) {
            alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Mensage de Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Error en su Usuario y/o Contaseña");
            alerta.showAndWait();
        }

    }

    @FXML
    void regBtn() throws IOException {

        
        int j = 0;
        while ((j++) < playerList.zise() ) {

            if (playerList.get(j - 1).getUsuario().equals(regNombreUsuario.getText())) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensage de Error");
                alerta.setHeaderText(null);
                alerta.setContentText("Usuario ya Existente");
                alerta.showAndWait();
                break;
            }
        }
        if (j > playerList.zise()) {
            Payer newPayer = new Payer();
            newPayer.setUsuario(regNombreUsuario.getText());
            newPayer.setContrasena(regContrasena.getText());
            newPayer.setPregunta(regPregunta.getValue());
            newPayer.setRespuesta(regRespuesta.getText());

            eviarPayer(newPayer, false);

            System.out.println("user user reguisted");
            App.setRoot("secondary");
        }

        limpiarFormularios();
    }

    public static void eviarPayer(Payer newPayer, boolean admin) {
        if (admin) {
            newPayer.setAdmin(1);
        } 
        try {
            PreparedStatement pStatement = cn.prepareStatement(
                    "INSERT INTO data (usuario,contrasena,pregunta,respuesta,tiempojugado,puntaje,turnos,admin) VALUES (?,?,?,?,?,?,?,?)");
            pStatement.setString(1, newPayer.getUsuario());
            pStatement.setString(2, newPayer.getContrasena());
            pStatement.setString(3, newPayer.getPregunta());
            pStatement.setString(4, newPayer.getRespuesta());
            pStatement.setTime(5, newPayer.getTiempoGuego());
            pStatement.setString(6, Integer.toString(newPayer.getPuntaje()));
            pStatement.setString(7, Integer.toString(newPayer.getTurnos()));
            pStatement.setString(8, Integer.toString(newPayer.isAdmin()));
            pStatement.executeUpdate();
            
            System.out.println("user user reguisted");
        } catch (Exception e) {
            payerselected = newPayer;
            System.out.println("Player no guardado en el server " + e);
            try {
                App.setRoot("secondary");
            } catch (IOException e1) {
                System.out.println(e);
            }

        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        // java.sql.Statement statement;
        // ResultSet rows;

        // try {
        // statement = cn.createStatement();
        // rows = statement.executeQuery("SELECT * FROM data");

        // while (rows.next()) {

        // }
        // } catch (SQLException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        System.out.println("");
        // try {

        // ResultSet rows = this.rows;
        // while (rows.next()) {
        // String usuario = rows.getString("usuario");
        // String contrasena = rows.getString("contrasena");

        // if (usuario.equals(iniNombreUsuario.getText()) &&
        // contrasena.equals(iniContrasena.getText())) {
        // System.out.println("user and pass ok");
        // App.setRoot("secondary");
        // } else {

        // Alert alerta = new Alert(Alert.AlertType.ERROR);
        // alerta.setTitle("Mensage de Error");
        // alerta.setHeaderText(null);
        // alerta.setContentText("Usuario o Contraseña Incorrectos");
        // alerta.showAndWait();
        // }
        // }
        // } catch (SQLException e) {
        // // TODO Auto-generated catch block
        // System.out.println("Error: " + e);
        // }

        limpiarFormularios();
    }

    private void limpiarFormularios() {
        iniNombreUsuario.setText("");
        iniContrasena.setText("");
        regNombreUsuario.setText("");
        regContrasena.setText("");
        regRespuesta.setText("");
        regPregunta.resetValidation();
    }
}
