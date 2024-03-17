/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject8;

import java.net.URL;
import java.util.ResourceBundle;

import com.mycompany.mavenproject8.Oters.Player;
import com.mycompany.mavenproject8.lista.Lista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author julio
 */
public class TablaController implements Initializable {
    private Lista list;
    private static int ID;
    private static Player selectedPayer;
    public static int getID() {
        return ID;
    }
    /**
     * Initializes the controller class.
     */

    @FXML
    private TableView<Player> tabla;

    @FXML
    private TableColumn<Player, Integer> id;

    @FXML
    private TableColumn<Player, String> usuario;

    @FXML
    private TableColumn<Player, Integer> partidas;

    @FXML
    private TableColumn<Player, Integer> movimientos;

    @FXML
    private TableColumn<Player, Integer> admin;

    @FXML
    private TableColumn<Player, Integer> puntajeMaximo;

    ObservableList<Player> players;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list = PrimaryController.getPlayerList();
        System.out.println("Se creo la lista correcta mente");
        players = FXCollections.observableArrayList();

        for (int i = 0; i < list.zise(); i++) {
            players.add(list.get(i));
        }
        tabla.setItems(players);
        
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));
       usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
       partidas.setCellValueFactory(new PropertyValueFactory<>("turnos"));
       //movimientos.setCellValueFactory(new PropertyValueFactory<>("movimientos")); // Asegúrate de que este atributo exista en la clase Payer
       admin.setCellValueFactory(new PropertyValueFactory<>("admin"));
       puntajeMaximo.setCellValueFactory(new PropertyValueFactory<>("puntaje"));

    }
    @FXML
    void filaCeleccionada(MouseEvent event) {
        selectedPayer = tabla.getSelectionModel().getSelectedItem();
        if (getSelectedPayer() != null) {
            ID = getSelectedPayer().getID();
        }
    }

    /**
     * @return the selectedPayer
     */
    public static Player getSelectedPayer() {
        return selectedPayer;
    }


}
