package com.examcreator.models.component;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 * Question
 */
public interface Component {
  String getType();

  String getText();

  void setText(String text);

  public XWPFParagraph getParagraph(XWPFDocument doc, int number);
}
