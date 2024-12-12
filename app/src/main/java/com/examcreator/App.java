package com.examcreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.examcreator.models.MultipleChoice;
import com.examcreator.models.Question;
import com.examcreator.utils.ExportToDocx;
import com.examcreator.views.QuestionListView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
    // BorderPane root = new BorderPane();
    Scene scene = new Scene(root);
    //
    // Button addTitleButton = new Button("Add Title");
    // Button exportButton = new Button("Export to DOCX");
    // // Create a new document
    // XWPFDocument doc = new XWPFDocument();
    //
    // // List of questions and their choices
    // List<Question> questions = new ArrayList<>();
    //
    // root.setTop(addTitleButton);
    //
    // // Center: Question List and Add Button
    // QuestionListView questionListView = new QuestionListView();
    // Button addQuestionButton = new Button("Add Question");
    // MultipleChoice q = new MultipleChoice("What is the capital of France?",
    // Arrays.asList("A. Paris", "B. London", "C. Rome", "D. Madrid"));
    // addQuestionButton.setOnAction(e -> {
    // questionListView.addQuestion(q);
    // questions.add(q);
    // });
    // // Top Menu (Add Title and Export Button)
    // exportButton.setOnAction(e -> {
    // ExportToDocx.exportExam(doc, questions, "newExam.docx");
    // });
    // // Bottom: Add Question and Export Buttons Side by Side
    // HBox bottomControls = new HBox(10); // Add spacing between buttons
    // bottomControls.getChildren().addAll(addQuestionButton, exportButton);
    // root.setBottom(bottomControls);
    // root.setCenter(questionListView.getView());

    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
