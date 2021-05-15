package org.fis.pc.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.fis.pc.model.Order;
import org.fis.pc.model.Post;
import org.fis.pc.model.User;

import java.io.IOException;

public class ViewOrdersController {
    private FXMLLoader loader;
    private Parent root;
    private Scene scene;
    private Stage stage;
    private static Order thisOrder;



    private static ObservableList<Order> list = FXCollections.observableArrayList();
    public static ObservableList<Order> getList() {
        return list;
    }
    @FXML
    private TableView<Order> ordersTable;

    @FXML
    private TableColumn<Order, String> photoNameColumn;

    @FXML
    private TableColumn<Order, String> buyerNameColumn;

    @FXML
    private TableColumn<Order, String> buyerEmailColumn;

    @FXML
    private void initialize()
    {

        fillTable();
    }

    public static Order getThisOrder()
    {
        return thisOrder;
    }

    public void loadOrders(){

        Order order1 = new Order("pozaradu","poza","ciulpiralu");
        Order order2 = new Order("raluca","munte","radu");
        Order order3 = new Order("loredana","pisica","bruno");
        list.add(order1);
        list.add(order2);
        list.add(order3);

        ordersTable.setItems(list);
    }

    public static void deleteOrder(Order order){
        list.remove(order);
    }

    @FXML
    void backButton() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("photographerHomepage.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280, 720);
        stage = (Stage) ordersTable.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void viewOrderAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("manageOrders.fxml"));
        root = loader.load();
        thisOrder=ordersTable.getSelectionModel().getSelectedItem();
        scene = new Scene(root, 1280, 720);
        stage = (Stage) ordersTable.getScene().getWindow();
        stage.setScene(scene);
    }

    private void fillTable(){
        photoNameColumn.setMinWidth(250);
        buyerNameColumn.setMinWidth(250);
        buyerEmailColumn.setMinWidth(250);

        photoNameColumn.setText("Photo name");
        buyerNameColumn.setText("Buyer name");
        buyerEmailColumn.setText("Buyer email");

        photoNameColumn.setCellValueFactory(new PropertyValueFactory<>("photoName"));
        buyerNameColumn.setCellValueFactory(new PropertyValueFactory<>("buyerName"));
        buyerEmailColumn.setCellValueFactory(new PropertyValueFactory<>("buyerEmail"));
        loadOrders();

    }

}
