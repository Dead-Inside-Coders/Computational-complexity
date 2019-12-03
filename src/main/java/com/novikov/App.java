package com.novikov;

import com.novikov.application.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static Stage primaryStage;
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Object a = Controller.class.getResource("Form.fxml");
        Parent root = FXMLLoader.load(getClass().getResource("Form.fxml"));
        primaryStage.setTitle("Сложность");
        primaryStage.setScene(new Scene(root));
        runStage(primaryStage);
    }

    public static void runStage(Stage stage) throws IOException
    {
        primaryStage = stage;
        primaryStage.show();
    }
}
