package com.example.javafxemailclient.controller;

import com.example.javafxemailclient.EmailManager;
import com.example.javafxemailclient.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

public class ComposeMessageControler  extends BaseController{


    @FXML
    private Label errorLabel;

    @FXML
    private HTMLEditor htmlEditor;

    @FXML
    private TextField recipientTextField;

    @FXML
    private TextField subjectTextField;

    @FXML
    void sendButtonAction() {
        System.out.println("send button clicked!");
    }
    public ComposeMessageControler(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }
}
