package com.example.javafxemailclient.controller;

import com.example.javafxemailclient.EmailManager;
import com.example.javafxemailclient.controller.services.LoginService;
import com.example.javafxemailclient.model.EmailAccount;
import com.example.javafxemailclient.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {
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
            loginService.start();
            loginService.setOnSucceeded(event -> {

                EmailLoginResult emailLoginResult = loginService.getValue();

                switch (emailLoginResult){
                    case SUCCESS:

                        if (!viewFactory.isMainViewInitialized()){
                            viewFactory.showMainWindow();
                        }

                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                        return;
                    case  FAILED_BY_CREDENTIALS:
                        errorLabel.setText("invaild credentials!");
                        return;
                    case FAILED_BY_UNEXPECTED_ERROR:
                        errorLabel. setText("unexpected error");
                        return;
                    default:
                        return;
                }
            });

        }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
