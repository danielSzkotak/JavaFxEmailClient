module com.example.javafxemailclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafxemailclient to javafx.fxml;
    exports com.example.javafxemailclient;
}