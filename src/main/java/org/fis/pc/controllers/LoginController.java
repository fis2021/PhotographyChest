package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private FXMLLoader loader;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public boolean checkUserCredentials(String usernameField, String passwordField){
        return true;
    }

    @FXML
    void handleLoginAction() {
        if(checkUserCredentials(usernameField.getText(),passwordField.getText())){
            System.out.println("Log in successful!");
        }
    }

    @FXML
    void handleSignupAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("signup.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280,720);
        stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
    }

}
