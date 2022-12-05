module com.example.javafxemailclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires activation;
    requires java.mail;
    requires java.desktop;

    //requires org.kordamp.bootstrapfx.core;

    opens com.example.javafxemailclient to javafx.fxml;
    exports com.example.javafxemailclient;
    opens com.example.javafxemailclient.view to javafx.fxml;
    exports com.example.javafxemailclient.controller;
    opens com.example.javafxemailclient.controller to javafx.fxml;
    opens com.example.javafxemailclient.model;

}