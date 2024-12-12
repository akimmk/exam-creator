package com.examcreator.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.examcreator.models.Exam;
import com.examcreator.models.MultipleChoice;
import com.examcreator.models.Question;
import com.examcreator.utils.SerializationUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;

/**
 * AppController
 */
public class AppController {

  private Exam currentExam;

  @FXML
  private TextField examTitleField;
  @FXML
  private ListView<Question> questionsListView;

  private ObservableList<Question> questionObservableList;

  @FXML
  public void initialize() {
    currentExam = new Exam("Untitled Exam");
    questionObservableList = FXCollections.observableArrayList(currentExam.getQuestions());
    questionsListView.setItems(questionObservableList);
    examTitleField.setText(currentExam.getTitle());
  }

  @FXML
  public void updateExamTitle() {
    currentExam.setTitle(examTitleField.getText());
  }

  @FXML
  public void addQuestion() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Add Question");
    dialog.setHeaderText("Enter the question text:");
    Optional<String> result = dialog.showAndWait();

    result.ifPresent(questionText -> {
      List<String> choices = Arrays.asList("Paris", "London", "Berlin", "Madrid");
      Question newQuestion = new MultipleChoice(questionText, choices);
      currentExam.addQuestion(newQuestion);
      questionObservableList.add(newQuestion);
    });
  }

  @FXML
  public void deleteSelectedQuestion() {
    Question selectedQuestion = questionsListView.getSelectionModel().getSelectedItem();
    if (selectedQuestion != null) {
      currentExam.removeQuestion(selectedQuestion);
      questionObservableList.remove(selectedQuestion);
    } else {
      showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a question to delete.");
    }
  }

  @FXML
  public void createNewExam() {
    TextInputDialog dialog = new TextInputDialog("New Exam");
    dialog.setTitle("Create New Exam");
    dialog.setHeaderText("Enter the title for the new exam:");
    Optional<String> result = dialog.showAndWait();

    result.ifPresent(title -> {
      currentExam = new Exam(title);
      showAlert(Alert.AlertType.INFORMATION, "New Exam Created", "Exam titled '" + title + "' has been created.");
    });
  }

  @FXML
  public void saveExam() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save Exam");
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Exam Files", "*.exam"));
    File file = fileChooser.showSaveDialog(null);

    if (file != null) {
      try {
        SerializationUtils.save(currentExam, file.getAbsolutePath() + ".exam");
        showAlert(Alert.AlertType.INFORMATION, "Exam Saved", "Exam has been saved successfully.");
      } catch (IOException e) {
        showAlert(Alert.AlertType.ERROR, "Error", "Failed to save the exam.");
        e.printStackTrace();
      }
    }
  }

  @FXML
  public void openExam() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Exam");
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Exam Files", "*.exam"));
    File file = fileChooser.showOpenDialog(null);

    if (file != null) {
      try {
        currentExam = SerializationUtils.load(file.getAbsolutePath(), Exam.class);
        questionObservableList = FXCollections.observableArrayList(currentExam.getQuestions());
        questionsListView.setItems(questionObservableList);
        examTitleField.setText(currentExam.getTitle());
        showAlert(Alert.AlertType.INFORMATION, "Exam Opened",
            "Exam titled '" + currentExam.getTitle() + "' has been opened.");
      } catch (IOException | ClassNotFoundException e) {
        showAlert(Alert.AlertType.ERROR, "Error", "Failed to open the exam.");
        e.printStackTrace();
      }
    }
  }

  private void showAlert(Alert.AlertType alertType, String title, String content) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setContentText(content);
    alert.showAndWait();
  }
}
