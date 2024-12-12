package com.examcreator.models;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * TrueOrFalse
 */
public class TrueOrFalse implements Question {

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getType'");
  }

  @Override
  public String getQuestionText() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getQuestionText'");
  }

  @Override
  public void setQuestionText(String text) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setQuestionText'");
  }

  @Override
  public XWPFParagraph getQuestion(XWPFDocument doc, int number) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getQuestion'");
  }

}
