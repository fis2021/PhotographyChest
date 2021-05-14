package org.fis.pc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.dizitart.no2.objects.ObjectRepository;
import org.fis.pc.controllers.PostPageController;
import org.fis.pc.model.Post;
import org.fis.pc.services.FileSystemService;
import org.fis.pc.services.PostService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        initDirectory();
        PostService.initDatabase();
        Parent root;
        Scene scene;
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
        root = loader.load();
        scene = new Scene(root,1280,720);
        primaryStage.setTitle("Photography Chest");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
}