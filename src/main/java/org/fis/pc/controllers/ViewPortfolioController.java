package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.fis.pc.model.Post;

import java.io.IOException;

public class ViewPortfolioController {

    private FXMLLoader loader;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private TableView<Post> table;
    @FXML
    private TableColumn<Post, String> ownerColumn;

    @FXML
    private TableColumn<Post, String> nameColumn;

    @FXML
    private TableColumn<Post, String> priceColumn;

    @FXML
    private TableColumn<Post, String> categoryColumn;

    @FXML
    private TableColumn<Post, String> dateColumn;


    @FXML
    void handleHomepageAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("photographerHomepage.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280,720);
        stage = (Stage) table.getScene().getWindow();
        stage.setScene(scene);

    }

}
