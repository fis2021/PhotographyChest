package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fis.pc.exceptions.*;
import org.fis.pc.services.PostService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PostPhotoController {
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

    public PostPhotoController() {
    }


    @FXML
    void handleBrowseAction() throws NoImageSelectedException {
        try{
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png"));
            List <File> f = fc.showOpenMultipleDialog(null);
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
    void handleCancelPostAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("photographerHomepage.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280, 720);
        stage = (Stage) descriptionField.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void handlePostAction() throws NoImageSelectedException, NoNameException, NoCategoryException, NoPriceException, NoDescriptionException {
        try {
            PostService.addPost(nameField.getText(), priceField.getText(), categoryField.getValue(), descriptionField.getText(), image, LoginController.getUsername());
            errorMessage.setText("Your post was successfully added!");
        }
        catch (NoImageSelectedException | NoNameException | NoCategoryException | NoPriceException | NoDescriptionException e){
            errorMessage.setText(e.getMessage());
        }

    }

    @FXML
    private TextField nameField;

    @FXML
    public void initialize(){
        categoryField.getItems().addAll("Nature", "Animals", "People", "Sports", "Abstract");
    }
}
