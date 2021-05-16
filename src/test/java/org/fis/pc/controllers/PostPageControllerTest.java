package org.fis.pc.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.fis.pc.exceptions.*;
import org.fis.pc.model.Order;
import org.fis.pc.model.Post;
import org.fis.pc.services.FileSystemService;
import org.fis.pc.services.PostService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

@ExtendWith({ApplicationExtension.class})
class PostPageControllerTest {
    public final static String username = "USERNAME";
    public final static String password = "PASSWORD";
    public final static String name = "NAME";
    public final static String price = "123";
    public final static String category = "CATEGORY";
    public final static String description = "DESCRIPTION";
    public final static String image = "IMAGE";
    public final static String owner = "OWNER";

    @BeforeEach
    void setUp() throws IOException {
        FileSystemService.APPLICATION_FOLDER = ".test-photography-chest";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        PostService.initDatabase();
    }

    @AfterEach
    void tearDown() {
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
    @DisplayName("Post page Loads Correctly")
    void testPostPageLoadsCorrectly(FxRobot robot) throws NoNameException, NoImageSelectedException, NoCategoryException, NoDescriptionException, NoPriceException {
        PostService.addPost(name,price,category,description,image,owner);
        Post post = PostService.getAllPosts().get(0);

        robot.clickOn("#loginUsername");
        robot.write("USERNAME");
        robot.clickOn("#loginPassword");
        robot.write("PASSWORD");
        robot.clickOn("#loginButton");


        robot.clickOn("#homepageViewPortfolio");
        robot.type(KeyCode.UP);
        robot.clickOn("#portfolioTable");

        Assertions.assertThat(robot.lookup("#postName").queryText()).hasText(post.getName());
        Assertions.assertThat(robot.lookup("#postUsername").queryText()).hasText(post.getOwnerName());
        Assertions.assertThat(robot.lookup("#postPrice").queryText()).hasText(post.getPrice());
        Assertions.assertThat(robot.lookup("#postCategory").queryText()).hasText(post.getCategory());
        //Assertions.assertThat(robot.lookup("#descriptionArea").queryText()).hasText(post.getDescription());
    }

    @Test
    @DisplayName("Back button works")
    void testBackButton(FxRobot robot) throws NoNameException, NoImageSelectedException, NoCategoryException, NoDescriptionException, NoPriceException {
        PostService.addPost(name,price,category,description,image,owner);
        Post post = PostService.getAllPosts().get(0);

        robot.clickOn("#loginUsername");
        robot.write(username);
        robot.clickOn("#loginPassword");
        robot.write(password);
        robot.clickOn("#loginButton");


        robot.clickOn("#homepageViewPortfolio");
        robot.type(KeyCode.UP);
        robot.clickOn("#portfolioTable");
        robot.clickOn("#postBack");
    }
}