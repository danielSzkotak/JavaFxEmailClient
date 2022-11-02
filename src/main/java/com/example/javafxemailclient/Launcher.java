package com.example.javafxemailclient;

import com.example.javafxemailclient.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
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

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showMainWindow();
        viewFactory.updateStyles();

    }
}
