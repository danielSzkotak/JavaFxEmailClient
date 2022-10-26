package com.example.javafxemailclient.view;

import com.example.javafxemailclient.EmailManager;
import com.example.javafxemailclient.controller.BaseController;
import com.example.javafxemailclient.controller.LoginWindowController;
import com.example.javafxemailclient.controller.MainWindowController;
import com.example.javafxemailclient.controller.OptionsWindowController;
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


    //View options handling
    private ColorTheme colorTheme = ColorTheme.DEFAULT;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    private FontSize fontSize = FontSize.MEDIUM;


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

    public void showOptionsWindow(){
        System.out.println("Options Window called!!!");
        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
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
