/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject8;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.mycompany.mavenproject8.Oters.Player;
import com.mycompany.mavenproject8.lista.Lista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.PixelFormat;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author julio
 */
public class ReguisterAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Lista playerList;
    private String[] listaPreguntas = { "Nombre de la Primera Mascota?", "Cual es su Comida Favorita?",
            "Marca del Telefono Anterior?" };

    @FXML
    private JFXCheckBox admin;

    @FXML
    private Button btnRegusterAdmin;

    @FXML
    private PasswordField contrasena;

    @FXML
    private AnchorPane fromRegCuneta;

    @FXML
    private TextField nameUser;

    @FXML
    private JFXComboBox<String> pregunta;

    @FXML
    private TextField respuesta;

    @FXML
    void reguister(ActionEvent event) {

        int j = 0;
        while ((j++) < playerList.zise()) {

            if (playerList.get(j - 1).getUsuario().equals(nameUser.getText())) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Mensage de Error");
                alerta.setHeaderText(null);
                alerta.setContentText("Usuario ya Existente");
                alerta.showAndWait();
                break;
            }
        }
        if (j > playerList.zise()) {
            
        Player newPayer = new Player();
        newPayer.setUsuario(nameUser.getText());
        newPayer.setContrasena(contrasena.getText());
        newPayer.setPregunta(pregunta.getValue());
        newPayer.setRespuesta(respuesta.getText());
        PrimaryController.eviarPayer(newPayer, admin.isSelected());

        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Reguistrado");
        alerta.setHeaderText(null);
        alerta.setContentText("El usuario se registro exitosamente");
        alerta.showAndWait();

        limpiarFormularios();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        playerList = PrimaryController.getPlayerList();
        pregunta.getItems().addAll(listaPreguntas);
        limpiarFormularios();
    }

    public void limpiarFormularios() {
        nameUser.setText("");
        contrasena.setText("");
        respuesta.setText("");
        admin.setSelected(false);
    }

}
