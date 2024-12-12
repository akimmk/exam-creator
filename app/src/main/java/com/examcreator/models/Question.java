package com.examcreator.models;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * Question
 */
public interface Question {
  String getType();

  String getQuestionText();

  void setQuestionText(String text);

  public XWPFParagraph getQuestion(XWPFDocument doc, int number);
}
