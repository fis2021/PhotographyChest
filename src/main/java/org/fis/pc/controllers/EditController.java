package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fis.pc.exceptions.*;
import org.fis.pc.model.Post;
import org.fis.pc.services.PostService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EditController {
    private FXMLLoader loader;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private  String image;

    @FXML
    private TextField priceField;

    @FXML
    private TextField descriptionField;

    @FXML
    private ChoiceBox<String> categoryField;

    @FXML
    private Text errorMessage;

    @FXML
    private TextField nameField;


    @FXML
    void handleCancelPostAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("postPage.fxml"));
        root = loader.load();
        PostPageController pc = loader.getController();
        pc.loadPostPage(PostPageController.getThisPost());
        scene = new Scene(root, 1280, 720);
        stage = (Stage) descriptionField.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void handleSaveChangesAction() throws NoImageSelectedException, NoNameException, NoCategoryException, NoPriceException, NoDescriptionException, IOException {
        try {

            PostService.checkIfImageSelected(image);
            PostService.checkIfCategorySelected(categoryField.getValue());
            PostService.checkIfDescriptionSelected(descriptionField.getText());
            PostService.checkIfNameSelected(nameField.getText());
            PostService.checkIfPriceSelected(priceField.getText());
            Post post = PostPageController.getThisPost();
            post.setImage(image);
            post.setName(nameField.getText());
            post.setCategory(categoryField.getValue());
            post.setPrice(priceField.getText());
            post.setDescription(descriptionField.getText());
            PostService.editPost(PostPageController.getThisPost());

            errorMessage.setText("Your post was successfully edited!");
        }
        catch (NoImageSelectedException | NoNameException | NoCategoryException | NoPriceException | NoDescriptionException e){
            errorMessage.setText(e.getMessage());
        }

    }

    @FXML
    void handleBrowseAction() throws NoImageSelectedException {
        try{
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png"));
            List<File> f = fc.showOpenMultipleDialog(null);
            if(!(f == null)){
                for(File file:f)
                    image = file.getAbsolutePath();
            }
            else{
                throw new NoImageSelectedException();
            }

        }catch (NoImageSelectedException e){
            errorMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void initialize(){
        categoryField.getItems().addAll("Nature", "Animals", "People", "Sports", "Abstract");
        Post post = PostPageController.getThisPost();
        nameField.setText(post.getName());
        priceField.setText(post.getPrice());
        descriptionField.setText(post.getDescription());
    }

}

