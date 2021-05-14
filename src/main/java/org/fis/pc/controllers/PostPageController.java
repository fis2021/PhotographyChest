package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PostPageController {
    private FXMLLoader loader;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Text photoName;

    @FXML
    private ImageView imageView;

    @FXML
    private Text description;

    @FXML
    private Text usernameField;

    @FXML
    private Text price;

    @FXML
    private Text category;

    @FXML
    private Button backHomepage;

    @FXML
    private Text email;

}
