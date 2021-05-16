package org.fis.pc.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fis.pc.model.Order;

import java.io.IOException;

public class ManageOrdersController {

    private FXMLLoader loader;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private TextField delivery;

    @FXML
    private TextField rejection;

    @FXML
    void backButton() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("viewOrders.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280, 720);
        stage = (Stage) delivery.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void acceptOrder() throws IOException {
        ObservableList<Order> list = ViewOrdersController.getList();
        ViewOrdersController.deleteOrder(ViewOrdersController.getThisOrder());
        loader = new FXMLLoader(getClass().getClassLoader().getResource("viewOrders.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280, 720);
        stage = (Stage) delivery.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void rejectOrder() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("viewOrders.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280, 720);
        stage = (Stage) delivery.getScene().getWindow();
        stage.setScene(scene);
    }

}
