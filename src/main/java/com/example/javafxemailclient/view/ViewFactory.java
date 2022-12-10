package com.example.javafxemailclient.view;

import com.example.javafxemailclient.EmailManager;
import com.example.javafxemailclient.controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;
    private boolean mainViewInitialized = false;

    public ViewFactory(EmailManager emailManager) {

        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }

    public boolean isMainViewInitialized(){

        return mainViewInitialized;
    }


    //View options handling
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.SMALL;

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


    public void showLoginWindow(){
        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        initializeStage(controller, false);

    }

    public void showMainWindow(){
        BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
        initializeStage(controller, true);
        mainViewInitialized = true;

    }

    public void showOptionsWindow(){
        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        initializeStage(controller, false);
    }

    public void showComposeMessageWindow(){
        BaseController controller = new ComposeMessageControler(emailManager, this, "ComposeMessageWindow.fxml");
        initializeStage(controller, true);
    }

    public void showEmailDetailsWindow(){
        BaseController controller = new EmailDetailsController(emailManager, this, "EmailDetailWindow.fxml");
        initializeStage(controller, true);
    }

    public void showAboutWindow(){
        BaseController controller = new AboutWindowController(emailManager, this, "AboutWindow.fxml");
        initializeStage(controller, false);
    }

    private void initializeStage(BaseController baseController, boolean isResizeable){
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
        updateStyle(scene);
        Stage stage = new Stage();
        stage.setScene(scene);
        if (!isResizeable) {
            stage.setResizable(false);
        }

        stage.show();
        activeStages.add(stage);
    }



    public void closeStage(Stage stageToCLose){
        stageToCLose.close();
        activeStages.remove(stageToCLose);
    }

    public void disableResize(Stage stage){
        stage.setResizable(false);
    }


    public void updateAllStyles() {
        for (Stage stage: activeStages) {
            Scene scene = stage.getScene();
            updateStyle(scene);
        }
    }

    private void updateStyle(Scene scene){
        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
        scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
    }
}
