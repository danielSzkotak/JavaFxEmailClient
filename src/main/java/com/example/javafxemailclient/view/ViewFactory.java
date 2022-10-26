package com.example.javafxemailclient.view;

import com.example.javafxemailclient.EmailManager;
import com.example.javafxemailclient.controller.BaseController;
import com.example.javafxemailclient.controller.LoginWindowController;
import com.example.javafxemailclient.controller.MainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {

        this.emailManager = emailManager;
    }

    public void showLoginWindow(){
        System.out.println("show login window");

        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        initializeStage(controller);

    }

    public void showMainWindow(){
        System.out.println("Main Window called!");

        BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
        initializeStage(controller);

    }

    private void initializeStage(BaseController baseController){
        FXMLLoader fxmlLoader  = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);

        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage =new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stageToCLose){
        stageToCLose.close();
    }


}
