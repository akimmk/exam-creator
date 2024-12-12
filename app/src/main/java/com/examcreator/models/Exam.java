package com.examcreator.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Exam
 */
public class Exam implements Serializable {
  private static final long serialVersionUID = 1L;

  private String title;
  private List<Question> questions;

  public Exam(String title) {
    this.title = title;
    this.questions = new ArrayList<>();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void addQuestion(Question question) {
    this.questions.add(question);
  }

  public void removeQuestion(Question question) {
    this.questions.remove(question);
  }
}
