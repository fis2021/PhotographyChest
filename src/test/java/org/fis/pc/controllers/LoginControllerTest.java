package org.fis.pc.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith({ApplicationExtension.class})
class LoginControllerTest {
    public final static String username = "USERNAME";
    public final static String password = "PASSWORD";

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(root,1280,720));
        primaryStage.show();
    }

    @Test
    void testLogin(FxRobot robot){
        robot.clickOn("#loginUsername");
        robot.write("USERNAME");
        robot.clickOn("#loginPassword");
        robot.write("PASSWORD");
        robot.clickOn("#loginButton");
    }

    @Test
    void testEmptyUsername(FxRobot robot) {
        robot.clickOn("#loginPassword");
        robot.write("PASSWORD");
        robot.clickOn("#loginButton");

        assertThat(robot.lookup("#loginErrorMessage").queryText()).hasText("Please complete the missing fields!");
    }

    @Test
    void testEmptyPassword(FxRobot robot) {
        robot.clickOn("#loginUsername");
        robot.write("USERNAME");
        robot.clickOn("#loginButton");

        assertThat(robot.lookup("#loginErrorMessage").queryText()).hasText("Please complete the missing fields!");
    }
}