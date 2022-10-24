package com.example.javafxemailclient.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController {
    @FXML
    private TextField emailField;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordFiled;

    @FXML
    void loginButtonAction() {
        System.out.println("clicked!!!");
    }

}
