package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.pc.exceptions.EmptyFieldsException;
import org.fis.pc.services.UserService;

import java.io.IOException;

public class LoginController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private FXMLLoader loader;
    private static String username;

    @FXML
    private TextField usernameField;

    @FXML
    private Text errorMessage;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void handleLoginAction() throws IOException, EmptyFieldsException {
        try {
            if(usernameField.getText().isEmpty()||passwordField.getText().isEmpty())
                throw new EmptyFieldsException();

            if (UserService.checkLoginCredentials(usernameField.getText(), passwordField.getText())) {
                username = usernameField.getText();
                System.out.println("Log in successful!");
                loader = new FXMLLoader(getClass().getClassLoader().getResource("photographerHomepage.fxml"));
                root = loader.load();
                scene = new Scene(root, 1280, 720);
                stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(scene);
            } else
                errorMessage.setText("Incorrect username or password!");
        }catch(EmptyFieldsException e){
            errorMessage.setText(e.getMessage());
        }
    }

    public static String getUsername(){
        return username;
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
