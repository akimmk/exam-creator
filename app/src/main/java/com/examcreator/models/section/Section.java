package com.examcreator.models.section;

import java.util.List;

import com.examcreator.models.component.Component;

public interface Section {
    public String getTitle();

    public void setTitle(String title);
    public List<Component> getQuestions();
}