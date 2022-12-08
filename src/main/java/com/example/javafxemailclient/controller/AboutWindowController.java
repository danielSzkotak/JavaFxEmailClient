package com.example.javafxemailclient.controller;

import com.example.javafxemailclient.EmailManager;
import com.example.javafxemailclient.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class AboutWindowController extends BaseController implements Initializable {

    public AboutWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private Button exitBtn;

    @FXML
    private TextArea aboutTextArea;

    @FXML
    void exitAboutBtnAction() {
        Stage stage = (Stage) aboutTextArea.getScene().getWindow();
        viewFactory.closeStage(stage);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aboutTextArea.setEditable(false);
        aboutTextArea.setMouseTransparent(true);
        aboutTextArea.setFocusTraversable(false);
        exitBtn.setFocusTraversable(false);
    }
}
