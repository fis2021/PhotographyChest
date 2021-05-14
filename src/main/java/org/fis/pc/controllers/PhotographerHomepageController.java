package org.fis.pc.controllers;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;

        import java.io.IOException;

public class PhotographerHomepageController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    private FXMLLoader loader;

    @FXML
    public void initialize(){
        usernameField.setText(LoginController.getUsername()+"!");
    }
    @FXML
    private Text usernameField;

    @FXML
    void handleLogoutAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280,720);
        stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void handleNewPostAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("postPhoto.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280,720);
        stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void handleViewOrdersAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("viewOrders.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280,720);
        stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void handleViewPortfolioAction() throws IOException {
        loader = new FXMLLoader(getClass().getClassLoader().getResource("viewPortfolio.fxml"));
        root = loader.load();
        scene = new Scene(root, 1280,720);
        stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
    }

}
