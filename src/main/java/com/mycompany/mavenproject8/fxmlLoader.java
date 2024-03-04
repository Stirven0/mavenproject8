package com.mycompany.mavenproject8;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


import java.net.URL;

public class fxmlLoader {
    private Parent view;

    public Parent getParent(String fileName){

        try{
            URL fileURL = App.class.getResource(fileName+".fxml");
            if (fileURL == null){
                throw new java.io.FileNotFoundException("La URL del archivo esta vacio");
            }
            view = FXMLLoader.load(fileURL);
        }catch (IOException e){
            System.out.printf(""+e);
        }
        return view;
    }
}
