package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fis.pc.services.UserService;

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

    @FXML
    void handleLoginAction() throws IOException {
        if(UserService.checkLoginCredentials(usernameField.getText(),passwordField.getText())){
            System.out.println("Log in successful!");
            loader = new FXMLLoader(getClass().getClassLoader().getResource("photographerHomepage.fxml"));
            root = loader.load();
            PhotographerHomepageController phc = loader.getController();
            phc.loadMessage(usernameField.getText());
            scene = new Scene(root, 1280,720);
            stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(scene);
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
