package com.company;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

//import java.awt.*;


public class QuestionController {
    @FXML
    private VBox vbox;
    @FXML
    private Label pytanie;
    List<RadioButton> radioButtons = new ArrayList<RadioButton>();

    private Main mainApp;
    private Timeline timeline;

    private void checkDrools() {
        if (mainApp.getQuestion().getQuestionSet()) {
        	mainApp.getQuestion().setQuestionSet(false);
            timeline.stop();
            VistaNavigator.loadVista(VistaNavigator.QUESTION);
        } else if (mainApp.getQuestion().getEnd()) {
            mainApp.getQuestion().setEnd(false);
            timeline.stop();
            VistaNavigator.loadVista(VistaNavigator.END);
        }
    }


    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae->checkDrools()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        pytanie.setText(mainApp.getQuestion().getQuestion());
        ToggleGroup group = new ToggleGroup();
        for (String list : mainApp.getQuestion().getAnswers()) {
            RadioButton radioButton = new RadioButton(list);
            radioButton.setToggleGroup(group);
            vbox.getChildren().add(radioButton);
            radioButtons.add(radioButton);
        }
    }

    @FXML
    void Answer(ActionEvent event) {

        for (RadioButton radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                mainApp.getQuestion().setAnswer(radioButton.getText());
                System.out.println(radioButton.getText());
                mainApp.droolsThread.t.interrupt();
                break;
            }
        }
    }
    @FXML
    void Lose(ActionEvent event) {
        //todo
        System.out.println("Pomiń");
    }
    /**
     * Event handler fired when the user requests a previous vista.
     *
     * @param event the event that triggered the handler.
     */


}