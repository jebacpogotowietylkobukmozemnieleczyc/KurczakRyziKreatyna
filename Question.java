package com.company;

import com.thoughtworks.xstream.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klimas on 30.11.15.
 */
public class Question {
	
    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question, List<String> answers) {
        this.question = question;
        this.answers.clear();
		for (String answer : answers)
	    {
			this.answers.add(answer);
		}
		this.questionSet = true;
    }
    
    public void setQuestion(String question, List<String> answers, DroolsThread thread) {
        this.question = question;
        this.answers.clear();
		for (String answer : answers)
	    {
			this.answers.add(answer);
		}
		this.questionSet = true;
		thread.Wait();
    }


    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Question() {
        this.questionSet = false;
        this.end = false;
    }

    public Boolean getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(Boolean questionSet) {
        this.questionSet = questionSet;
    }


    public Boolean getEnd() {
        return end;
    }

    public void setEnd(Boolean end) {
        this.end = end;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setEndController(EndController endController) {
        this.endController = endController;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private EndController endController;
    private Boolean questionSet;
    private Boolean end;
    private String question;
    private String answer;


    private String result;
    List<String> answers = new ArrayList<String>();
}
