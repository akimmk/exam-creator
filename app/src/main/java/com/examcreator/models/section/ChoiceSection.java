package com.examcreator.models.section;

import java.util.List;

import com.examcreator.models.component.Component;

public class ChoiceSection implements Section{
    private String title;

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public List<Component> getQuestions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getQuestions'");
    }
    
}
