package com.examcreator.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.examcreator.models.section.Section;

/**
 * Exam
 */
public class Exam implements Serializable {
  private static final long serialVersionUID = 1L;

  private String title;
  public List<Section> sections;

  public Exam(String title) {
    this.title = title;
    this.sections = new ArrayList<>();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<Section> getSections() {
    return this.sections;
  }

}
