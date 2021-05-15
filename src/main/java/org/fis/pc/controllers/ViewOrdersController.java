package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewOrdersController {
    private FXMLLoader loader;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private TableView<?> ordersTable;

    @FXML
    private TableColumn<?, ?> photoNameColumn;

    @FXML
    private TableColumn<?, ?> buyerNameColumn;

    @FXML
    private TableColumn<?, ?> buyerEmailColumn;

    @FXML
    void backButton() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("photographerHomepage.fxml"));
        root = loader.load();
        PostPageController pc = loader.getController();
        pc.loadPostPage(PostPageController.getThisPost());
        scene = new Scene(root, 1280, 720);
        stage = (Stage) ordersTable.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void viewOrderAction() {

    }

}
