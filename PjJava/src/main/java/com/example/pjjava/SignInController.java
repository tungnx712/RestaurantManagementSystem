package com.example.pjjava;

import dao.JDBCConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    @FXML
    private AnchorPane main_form;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginBtn;
    @FXML
    private Button close;

    private double x = 0;
    private double y = 0;



    public void setParamForAdmin(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, username.getText());
        preparedStatement.setString(2, password.getText());
    }

    public void login() throws Exception {
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";

        try (Connection connection = JDBCConnect.getJDBCConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            setParamForAdmin(preparedStatement);
            Alert alert;

            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                // IF USERNAME/PASSWORD EMPTY
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Username/ Password cannot be empty");
                alert.showAndWait();
            } else {
                try (ResultSet resultSet = preparedStatement.executeQuery();) {
                    if (resultSet.next()) {

                        data.username = username.getText();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Login!");
                        alert.showAndWait();

                        // TO HIDE LOGIN FORM
                        loginBtn.getScene().getWindow().hide();

                        // LINK DASHBOARD
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);

                        root.setOnMousePressed((MouseEvent event) -> {
                            x = event.getSceneX();
                            y = event.getSceneY();
                        });

                        root.setOnMouseDragged((MouseEvent event) -> {
                            stage.setX(event.getScreenX() - x);
                            stage.setY(event.getScreenY() - y);

                            stage.setOpacity(.8f);
                        });

                        root.setOnMouseReleased((MouseEvent event) -> {
                            stage.setOpacity(1);
                        });

                        stage.initStyle(StageStyle.TRANSPARENT);

                        stage.setScene(scene);
                        stage.show();
                    } else {
                        // IF WRONG USERNAME/PASSWORD YOU'VE ENTERED
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong Username/Password");
                        alert.showAndWait();
                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    // CLOSE THE PROGRAM
    public void close() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
