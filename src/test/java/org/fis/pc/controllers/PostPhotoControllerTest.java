package org.fis.pc.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.fis.pc.exceptions.*;
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
import static org.testfx.assertions.api.Assertions.assertThat;
import java.io.IOException;

@ExtendWith({ApplicationExtension.class})
class PostPhotoControllerTest {
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
    void testAddItem(FxRobot robot){
        robot.clickOn("#loginUsername");
        robot.write("username");
        robot.clickOn("#loginPassword");
        robot.write("password");
        robot.clickOn("#loginButton");

        robot.clickOn("#homepageAddButton");

        robot.clickOn("#addPostName");
        robot.write("Post name");
        robot.clickOn("#addPostPrice");
        robot.write("123");

        robot.clickOn("#postButton");
        assertThat(robot.lookup("#addPostMessage").queryText()).hasText("Please select a photo first!");

        /*PostPhotoController.setImage("image");

        robot.clickOn("#postButton");

        assertThat(robot.lookup("#addPostMessage").queryText()).hasText("Please select a category first!");

        robot.clickOn("#addCategory");
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.ENTER);

        robot.clickOn("#postButton");
        assertThat(robot.lookup("#addItemMessage").queryText()).hasText("Please select a photo first!");

        robot.clickOn("#addDescription");
        robot.write("Post description");

        robot.clickOn("#postButton");
        assertThat(robot.lookup("#addItemMessage").queryText()).hasText("Please select a photo first!");

        /*AddPostController.setImage("Image link");

        robot.clickOn("#postButton");
        assertThat(robot.lookup("#addItemMessage").queryText()).hasText("Item added successfully!");
*/
    }
}