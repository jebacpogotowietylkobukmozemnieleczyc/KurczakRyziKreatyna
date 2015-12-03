package com.company;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

//import java.awt.*;


public class Vista2Controller {
    @FXML
    private HBox hbox;
    @FXML
    private Label pytanie;

    private Main mainApp;
    private Timeline timeline;

    private void CheckDrools(){
        if(mainApp.getQuestion().getQuestionSet()){
            mainApp.getQuestion().setQuestionSet(false);
            timeline.stop();
            VistaNavigator.loadVista(VistaNavigator.VISTA_2);
        }
    }



    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> CheckDrools()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

       pytanie.setText(mainApp.getQuestion().getQuestion());
        hbox.getChildren().clear();
        for(String list :mainApp.getQuestion().getMyList()){
            Button btn = new Button(list);
            hbox.getChildren().add(btn);
            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    mainApp.droolsThread.t.interrupt();

                }
            });
        }

    }
    /**
     * Event handler fired when the user requests a previous vista.
     *
     * @param event the event that triggered the handler.
     */

}