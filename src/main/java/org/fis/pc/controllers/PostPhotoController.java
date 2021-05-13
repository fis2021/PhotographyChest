package org.fis.pc.controllers;

import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.TextField;

public class PostPhotoController {

    @FXML
    private TextField priceField;

    @FXML
    private TextField descriptionField;

    @FXML
    private ChoiceBox<?> categoryField;

    @FXML
    private Button handleBrowsePhotoAction;

    @FXML
    private Button handleCancelPostAction;

    @FXML
    private TextField nameField;

}
