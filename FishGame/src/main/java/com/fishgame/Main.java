package com.fishgame;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        //Launches the Application
        launch(args);
    }

    @Override
    public void start(Stage _stage) {
        //Calls the Initialize Method from the SceneManager and passes the _stage as a parameter
        SceneManager.Initialize(_stage);
    }
}
