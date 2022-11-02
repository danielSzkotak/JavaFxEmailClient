package com.example.javafxemailclient.controller;

import com.example.javafxemailclient.EmailManager;
import com.example.javafxemailclient.controller.services.LoginService;
import com.example.javafxemailclient.model.EmailAccount;
import com.example.javafxemailclient.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {
    @FXML
    private TextField emailField;

    @FXML
    private Label errorLabel;

    @FXML
    private PasswordField passwordField;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {

        if (fieldsAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            EmailLoginResult emailLoginResult = loginService.login();

            switch (emailLoginResult){
                case SUCCESS:
                    System.out.println("login succesfull !!!" + emailAccount);
                    return;
            }
        }
        System.out.println("loginButtonAction!");
        viewFactory.showMainWindow();
        Stage stage = (Stage) errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);

    }

    private boolean fieldsAreValid() {
        if (emailField.getText().isEmpty()){
            errorLabel.setText("Please fill email");
            return false;
        }
        if (passwordField.getText().isEmpty()){
            errorLabel.setText("Please fill password");
            return false;
        }
        return true;
    }

}
