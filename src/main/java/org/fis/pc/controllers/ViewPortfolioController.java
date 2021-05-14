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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.fis.pc.model.Post;
import org.fis.pc.services.PostService;

import java.io.IOException;

public class ViewPortfolioController {

    private FXMLLoader loader;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private TableView<Post> table;
    @FXML
    private TableColumn<ImageView, String> ownerColumn;

    @FXML
    private TableColumn<Post, String> nameColumn;

    @FXML
    private TableColumn<Post, String> priceColumn;

    @FXML
    private TableColumn<Post, String> categoryColumn;

    @FXML
    private TableColumn<Post, String> dateColumn;

    @FXML
    private void initialize(){
        fillTable();
    }

    private void loadPosts(){
        ObjectRepository<Post> posts = PostService.getPostRepository();
        ObservableList<Post> postsList = FXCollections.observableArrayList();
        for(Post post: posts.find()){
            postsList.add(post);
        }
        table.setItems(postsList);
    }

    private void fillTable(){
        ownerColumn.setMinWidth(250);
        nameColumn.setMinWidth(250);
        priceColumn.setMinWidth(250);
        categoryColumn.setMinWidth(250);
        dateColumn.setMinWidth(250);

        nameColumn.setText("Photo name");
        priceColumn.setText("Price");
        categoryColumn.setText("Category");
        dateColumn.setText("Date added");

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));


        loadPosts();
    }
    @FXML
    void handleHomepageAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("photographerHomepage.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280,720);
        stage = (Stage) table.getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    void goToPostpage() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("postPage.fxml"));
        root = loader.load();
        PostPageController pc = loader.getController();
        pc.loadPostPage(table.getSelectionModel().getSelectedItem());
        scene = new Scene(root, 1280,720);
        stage = (Stage) table.getScene().getWindow();
        stage.setScene(scene);

    }

}
