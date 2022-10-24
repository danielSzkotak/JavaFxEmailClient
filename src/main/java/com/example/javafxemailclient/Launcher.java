package com.example.javafxemailclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static java.util.Objects.*;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("view/LoginWindow.fxml"));
        //FXMLLoader parent = new FXMLLoader(Launcher.class.getResource("firstFXML.fxml"));

        Scene scene = new Scene(parent, 495, 370);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
