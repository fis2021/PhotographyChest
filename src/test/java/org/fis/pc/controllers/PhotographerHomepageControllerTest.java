package org.fis.pc.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.fis.pc.model.Order;
import org.fis.pc.services.FileSystemService;
import org.fis.pc.services.PostService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

@ExtendWith({ApplicationExtension.class})
class PhotographerHomepageControllerTest {
    public final static String username = "USERNAME";
    public final static String password = "PASSWORD";

    @BeforeEach
    void setUp() throws IOException {
        FileSystemService.APPLICATION_FOLDER = ".test-photography-chest";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        PostService.initDatabase();
    }

    @AfterEach
    void tearDown(){
        PostService.getDatabase().close();
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }

    @Test
    @DisplayName("Logout button works")
    void testLogoutButton(FxRobot robot){
        robot.clickOn("#loginUsername");
        robot.write("USERNAME");
        robot.clickOn("#loginPassword");
        robot.write("PASSWORD");
        robot.clickOn("#loginButton");
        robot.clickOn("#homepageLogout");
    }

    @Test
    @DisplayName("Add new post button works")
    void testAddPostButton(FxRobot robot){
        robot.clickOn("#loginUsername");
        robot.write("USERNAME");
        robot.clickOn("#loginPassword");
        robot.write("PASSWORD");
        robot.clickOn("#loginButton");
        robot.clickOn("#homepageAddButton");
    }

    @Test
    @DisplayName("View portfolio button works")
    void testViewPortfolioButton(FxRobot robot){

        robot.clickOn("#loginUsername");
        robot.write("USERNAME");
        robot.clickOn("#loginPassword");
        robot.write("PASSWORD");
        robot.clickOn("#loginButton");
        robot.clickOn("#homepageViewPortfolio");
    }

    @Test
    void testViewOrdersButton(FxRobot robot){
        robot.clickOn("#loginUsername");
        robot.write("USERNAME");
        robot.clickOn("#loginPassword");
        robot.write("PASSWORD");
        robot.clickOn("#loginButton");
        robot.clickOn("#homepageViewOrders");
        TableView<Order> table = ViewOrdersController.getThisOrdersTable();

    }

}