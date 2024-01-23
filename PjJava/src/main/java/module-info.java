module com.example.pjjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.pjjava to javafx.fxml;
    exports com.example.pjjava;
}