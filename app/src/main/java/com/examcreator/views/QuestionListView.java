package com.examcreator.views;

import com.examcreator.models.component.Component;

import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 * QuestionListView
 */
public class QuestionListView {
  private VBox view;
  private ListView<Component> questionList;

  public QuestionListView() {
    this.view = new VBox();
    this.questionList = new ListView<>();
    this.view.getChildren().add(questionList);
  }

  public void addQuestion(Component question) {
    questionList.getItems().add(question);
  }

  public VBox getView() {
    return view;
  }
}
