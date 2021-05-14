package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.fis.pc.model.Post;

import java.io.IOException;

public class PostPageController {
    private FXMLLoader loader;
    private Parent root;
    private Scene scene;
    private Stage stage;
    private static Post thisPost;

    public static Post getThisPost()
    {
        return thisPost;
    }
    @FXML
    private Text photoName;

    @FXML
    private ImageView imageView;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Text usernameField;

    @FXML
    private Text price;

    @FXML
    private Text category;

    @FXML
    void handleBackButton() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("viewPortfolio.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280, 720);
        stage = (Stage) photoName.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    private Text email;


    public void loadPostPage(Post post) {
        usernameField.setText(post.getOwnerName());
        category.setText(post.getCategory());
        price.setText(post.getPrice());
        descriptionArea.setText(post.getDescription());
        photoName.setText(post.getName());
        descriptionArea.setEditable(false);
        imageView.setImage(new Image("file:"+post.getImage()));
    }


}
