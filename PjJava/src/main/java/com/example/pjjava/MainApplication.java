package com.example.pjjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class MainApplication extends Application {

    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage primaryStage) {
        try {

            Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("signIn.fxml")));
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                primaryStage.setX(event.getScreenX() - x);
                primaryStage.setY(event.getScreenY() - y);

                primaryStage.setOpacity(.8f);
            });

            root.setOnMouseReleased((MouseEvent event) -> {
                primaryStage.setOpacity(1);
            });

            primaryStage.initStyle(StageStyle.TRANSPARENT);

            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("signIn.css")).toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e)
        {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
