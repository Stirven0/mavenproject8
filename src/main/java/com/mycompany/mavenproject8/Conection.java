package com.mycompany.mavenproject8;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    Connection cn;
    public boolean conected;

    public Connection conexion (){
        String url = "jdbc:mysql://localhost:3306/"; //Direccion de la basde de datos (IP:puerto)
        String db = "usuarios";  //Nombre de la Base de Datos
        String usuario = "root";
        String contrasena = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url+db,usuario,contrasena);
            conected = true;
        } catch (SQLException | ClassNotFoundException e) {

            conected = false;
//            Alert alerta = new Alert(Alert.AlertType.ERROR);
//            alerta.setTitle("Mensage de Error");
//            alerta.setHeaderText(null);
//            alerta.setContentText("No fue posible conectar con la base de datos \nSe prosede a trabajar en local");
//            alerta.showAndWait();
//            System.out.println("Error: "+e);
            //throw new RuntimeException(e);
        }
        return cn;

    }
    public void desconeccion(){
        try {
            cn.close();
            System.out.println("Coneccion finalisada con exito");
            conected = false;
        } catch (SQLException e) {
            System.out.println("Error al filanisa la coneccion "+e);
        }
    }
}
