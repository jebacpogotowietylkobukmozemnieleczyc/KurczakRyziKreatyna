package com.company;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

/**
 * Controller class for the first vista.
 */
public class EndController {

    private Main mainApp;

    public void setWynik(Label wynik) {
        this.wynik = wynik;
    }

    public Label getWynik() {
        return wynik;
    }

    @FXML
    private Label wynik;
//    @FXML
//    void nextPane(ActionEvent event) {
//        VistaNavigator.loadVista(VistaNavigator.QUESTION);
//    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        wynik.setText(mainApp.getQuestion().getResult());
    }
}