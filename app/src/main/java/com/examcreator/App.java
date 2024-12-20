package com.examcreator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Exam Creator");

    System.out.println(getClass().getResource("/").getPath());
 
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
