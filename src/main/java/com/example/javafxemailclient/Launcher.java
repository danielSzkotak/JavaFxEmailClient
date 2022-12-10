package com.example.javafxemailclient;

import com.example.javafxemailclient.controller.persistence.PersistenceAccess;
import com.example.javafxemailclient.controller.persistence.VaildAccount;
import com.example.javafxemailclient.controller.services.LoginService;
import com.example.javafxemailclient.model.EmailAccount;
import com.example.javafxemailclient.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.web.WebView;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.*;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private PersistenceAccess persistenceAccess = new PersistenceAccess();
    private EmailManager emailManager = new EmailManager();

    @Override
    public void start(Stage primaryStage) throws Exception {

        ViewFactory viewFactory = new ViewFactory(emailManager);
        List<VaildAccount> vaildAccountList = persistenceAccess.loadFromPersistence();
        if (vaildAccountList.size() > 0){
            viewFactory.showMainWindow();
            for (VaildAccount vaildAccount: vaildAccountList){
                EmailAccount emailAccount = new EmailAccount(vaildAccount.getAddress(), vaildAccount.getPassword());
                LoginService loginService = new LoginService(emailAccount, emailManager);
                loginService.start();
            }
        } else {
            viewFactory.showLoginWindow();
        }

    }


    @Override
    public void stop() throws Exception {
        List<VaildAccount> vaildAccountList = new ArrayList<VaildAccount>();
        for (EmailAccount emailAccount: emailManager.getEmailAccounts()){
            vaildAccountList.add(new VaildAccount(emailAccount.getAddress(), emailAccount.getPassword()));
        }
        persistenceAccess.saveToPersistence(vaildAccountList);
    }
}
