package com.example.pjjava;

import dao.JDBCConnect;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HelloController {
    @FXML
    private Hyperlink si_forgotPass;

    @FXML
    private Button si_loginBtn;

    @FXML
    private AnchorPane si_loginform;

    @FXML
    private PasswordField si_password;

    @FXML
    private TextField si_username;

    @FXML
    private Button side_CreateBtn;

    @FXML
    private AnchorPane side_form;

    @FXML
    private TextField su_email;

    @FXML
    private PasswordField su_password;

    @FXML
    private TextField su_phonenumber;

    @FXML
    private Button su_signupBtn;

    @FXML
    private AnchorPane su_signupForm;

    @FXML
    private TextField su_username;

    @FXML
    private Button side_alreadyHave;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;
    private Alert alert;

    public void regBtn() {
        if (su_username.getText().isEmpty() || su_password.getText().isEmpty() ||
                su_phonenumber.getText().isEmpty() || su_email.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("Insert all field");
            alert.showAndWait();
        } else {
            String regData = "INSERT INTO admin (username, password, phonenumber, email)" + "VALUES(?,?,?,?)";
            connection = JDBCConnect.getJDBCConnection();
            try {
                String checkUsername = "SELECT username FROM admin WHERE username = '" +
                        su_username.getText() + "'";
                preparedStatement = connection.prepareStatement(checkUsername);
                result = preparedStatement.executeQuery();

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setContentText(su_username.getText() + "Username is already");
                    alert.showAndWait();
                } else if (su_password.getText().length() < 10) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setContentText("Ivalid password, atleast  10 length is needed");
                    alert.showAndWait();
                } else if (su_phonenumber.getText().matches("0\\d{9}")){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setContentText("Ivalid phone number, atleast  10 number is needed");
                    alert.showAndWait();

                }else if (su_email.getText().matches("^(.+)@(.+)$")){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setContentText("Ivalid Email");
                    alert.showAndWait();
                }
                else {
                    preparedStatement = connection.prepareStatement(regData);
                    preparedStatement.setString(1, su_username.getText());
                    preparedStatement.setString(2, su_password.getText());
                    preparedStatement.setString(3, su_phonenumber.getText());
                    preparedStatement.setString(4, su_email.getText());

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Infomation Message");
                    alert.setContentText("Successfully register account");
                    alert.showAndWait();

                    su_username.setText("");
                    su_password.setText("");
                    su_phonenumber.setText("");
                    su_email.setText("");

                    TranslateTransition slider = new TranslateTransition();
                    slider.setNode(side_form);
                    slider.setToX(0);
                    slider.setDuration(Duration.seconds(.5));
                    slider.setOnFinished((ActionEvent e) -> {
                        side_alreadyHave.setVisible(false);
                        side_CreateBtn.setVisible(true);
                    });
                    slider.play();

                    preparedStatement.executeUpdate();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void switchForm(ActionEvent event) {

        TranslateTransition slider = new TranslateTransition();

        if (event.getSource() == side_CreateBtn) {
            slider.setNode(side_form);
            slider.setToX(300);
            slider.setDuration(Duration.seconds(.5));
            slider.setOnFinished((ActionEvent e) -> {
                side_alreadyHave.setVisible(true);
                side_CreateBtn.setVisible(false);
            });
            slider.play();
        } else if (event.getSource() == side_alreadyHave) {
            slider.setNode(side_form);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));
            slider.setOnFinished((ActionEvent e) -> {
                side_alreadyHave.setVisible(false);
                side_CreateBtn.setVisible(true);
            });
            slider.play();
        }
    }
}