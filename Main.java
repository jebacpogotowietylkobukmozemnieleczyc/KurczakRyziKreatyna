package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class Main extends Application {
    public Question getQuestion() {
        return question;
    }

    static public Question question = new Question();
    static public StatefulKnowledgeSession statefulKnowledgeSession;
    public DroolsThread droolsThread;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Super Program");

        stage.setScene(
                createScene(
                        loadMainPane()
                )
        );

        stage.show();
    }

    private Pane loadMainPane() throws Exception {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        VistaNavigator.MAIN
                )
        );

        MainController mainController = loader.getController();

        VistaNavigator.setMainController(mainController);
        VistaNavigator.setMain(this);
        VistaNavigator.loadVista(VistaNavigator.START);


        droolsThread = new DroolsThread("drools", this);
        droolsThread.start();

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
                mainPane
        );

        scene.getStylesheets().setAll(
                getClass().getResource("vista.css").toExternalForm()
        );

        return scene;
    }

    public static final void main(String[] args) throws Exception {
        launch(args);
    }

    public static void setKnowledgeBAse(DroolsThread droolsThread) throws Exception {
        KnowledgeBase knowledgeBase = readKnowledgeBase();
        statefulKnowledgeSession = knowledgeBase.newStatefulKnowledgeSession();
        KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(statefulKnowledgeSession, "test");

        statefulKnowledgeSession.setGlobal("question", question);
        statefulKnowledgeSession.setGlobal("droolsThread", droolsThread);
        question.getAnswers().add("StartController");
        statefulKnowledgeSession.fireAllRules();
        logger.close();
    }


    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(ResourceFactory.newClassPathResource("drools/sample.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = knowledgeBuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error : errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(knowledgeBuilder.getKnowledgePackages());
        return knowledgeBase;
    }
}
