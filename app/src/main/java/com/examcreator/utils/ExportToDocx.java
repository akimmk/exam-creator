package com.examcreator.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.examcreator.models.Question;

/**
 * QuestionToDocx
 */
public class ExportToDocx {
  public static void exportExam(XWPFDocument doc, List<Question> questions, String path) {
    XWPFParagraph titleParagraph = doc.createParagraph();
    titleParagraph.setAlignment(ParagraphAlignment.CENTER);
    XWPFRun titleRun = titleParagraph.createRun();
    titleRun.setText("Sample Exam");
    titleRun.setBold(true);
    titleRun.setFontSize(16);

    // Add questions and choices to the document
    for (int i = 0; i < questions.size(); i++) {
      Question q = questions.get(i);
      q.getQuestion(doc, (i + 1));
    }

    try {
      // Save the document to a file
      FileOutputStream out = new FileOutputStream(path);
      doc.write(out);
      out.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println("Exam document created successfully.");
  }
}
