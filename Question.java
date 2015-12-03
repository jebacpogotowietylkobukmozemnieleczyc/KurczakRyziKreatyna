package com.company;

import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klimas on 30.11.15.
 */
public class Question {
    public String getQuestion() {
        return question;
    }
    public void ShowQusetion(){


        VistaNavigator.loadVista(VistaNavigator.VISTA_2);
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }


    public Boolean getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Boolean questionSet) {
        this.questionSet = questionSet;
    }

    private Boolean questionSet;
    private String question;
    List<String> myList = new ArrayList<String>();
}
