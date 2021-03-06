package com.company;

import javafx.fxml.FXMLLoader;
//import javafx.scene.cont

import javafx.scene.Node;

import java.io.IOException;

/**
 * Utility class for controlling navigation between vistas.
 * <p>
 * All methods on the navigator are static to facilitate
 * simple access from anywhere in the application.
 */
public class VistaNavigator {

    /**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public static final String MAIN = "main.fxml";
    public static final String START = "start.fxml";
    public static final String QUESTION = "question.fxml";
    public static final String END = "end.fxml";

    /**
     * The main application layout controller.
     */
    private static MainController mainController;
    private static Main main;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
    public static void setMainController(MainController mainController) {
        VistaNavigator.mainController = mainController;
    }

    public static void setMain(Main main) {
        VistaNavigator.main = main;
    }

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     * <p>
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     * <p>
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     * cache FXMLLoaders
     * cache loaded vista nodes, so they can be recalled or reused
     * allow a user to specify vista node reuse or new creation
     * allow back and forward history like a browser
     *
     * @param fxml the fxml file to be loaded.
     */
    public static void loadVista(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader();
            mainController.setVista(
                    loader.load(
                            VistaNavigator.class.getResourceAsStream(
                                    fxml
                            )
                    )
            );
            if (fxml == "question.fxml") {
                QuestionController questionController = loader.<QuestionController>getController();
                questionController.setMainApp(main);
            }
            if (fxml == "end.fxml") {
                EndController endController = loader.<EndController>getController();
                endController.setMainApp(main);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}