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
    private Button backHomepage;

    @FXML
    private Text email;


    public void loadPostPage(Post post) throws IOException {
        usernameField.setText(post.getOwnerName());
        category.setText(post.getCategory());
        price.setText(post.getPrice());
        descriptionArea.setText(post.getDescription());
        photoName.setText(post.getName());
        imageView.setImage(new Image("file:"+post.getImage()));
    }


}
