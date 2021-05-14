package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import org.fis.pc.exceptions.NoImageSelectedException;
import org.fis.pc.services.PostService;

import java.io.File;
import java.util.List;

public class PostPhotoController {

    @FXML
    private String image = new String();

    @FXML
    private TextField priceField;

    @FXML
    private TextField descriptionField;

    @FXML
    private ChoiceBox<String> categoryField;

    @FXML
    private Text errorMessage;


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
    void handleCancelPostAction() {

    }

    @FXML
    void handlePostAction() {
        PostService.addPost(nameField.getText(), priceField.getText(), categoryField.getValue(), descriptionField.getText(), image, LoginController.getUsername());


    }

    @FXML
    private TextField nameField;

    @FXML
    public void initialize(){
        categoryField.getItems().addAll("Nature", "Animals", "People", "Sports", "Abstract");
    }
}
