package org.fis.pc.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

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
    void backButton() {

    }

    @FXML
    void viewOrderAction() {

    }

}
