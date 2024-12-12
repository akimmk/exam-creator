package com.examcreator.models;

import java.io.Serializable;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * MultipleChoice
 */
public class MultipleChoice implements Question, Serializable {
  private static final long serialVersionUID = 2L;

  private final String questionText;
  private final List<String> choices;

  public MultipleChoice(String questionText, List<String> choices) {
    this.questionText = questionText;
    this.choices = choices;
  }

  public List<String> getChoices() {
    return choices;
  }

  @Override
  public String getType() {
    // TODO: Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getType'");
  }

  @Override
  public String getQuestionText() {
    return questionText;
  }

  @Override
  public void setQuestionText(String text) {
    // TODO: Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setQuestionText'");
  }

  @Override
  public XWPFParagraph getQuestion(XWPFDocument doc, int number) {
    XWPFParagraph questionParagraph = doc.createParagraph();
    XWPFRun questionRun = questionParagraph.createRun();
    questionRun.setText(number + ". " + this.getQuestionText());
    questionRun.setBold(true);
    questionRun.setFontSize(12);

    // Add choices
    for (String choice : this.getChoices()) {
      XWPFParagraph choiceParagraph = doc.createParagraph();
      choiceParagraph.setIndentationLeft(500); // Indent choices
      XWPFRun choiceRun = choiceParagraph.createRun();
      choiceRun.setText(choice);
      choiceRun.setFontSize(12);
    }
    return questionParagraph;
  }

}
