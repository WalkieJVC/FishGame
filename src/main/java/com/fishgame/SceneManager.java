package com.fishgame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.math.BigDecimal;
import java.util.Objects;

public class SceneManager{
    //Variables
    private static Stage _stage;
    private static FXMLLoader _fxmlLoader;
    private static Pane _pane;
    private static Scene _scene;


    //InitializePrimaryStage
    public static void Initialize(Stage stage) {
        //Assigns the parameter stage to the variable _stage
        _stage = stage;
        //Creates a new instance of an FXMLLoader and gets the LoginPage fxml file
        _fxmlLoader = new FXMLLoader(Main.class.getResource("FXMLFiles/Base.fxml"));

        //Try-Catch used to catch any errors
        try{
            //Creates a new scene instance and passes the loaded fxml file and the window dimensions
            _scene = new Scene(_fxmlLoader.load(), 640, 720);
        }catch (Exception _e){
            //Displays a message to the console with the cause of the error
            System.out.println("Unable To Load - ERROR Cause: " + _e.getCause());
            return; //Returns
        }

        //Creates a new instance of an Image and gets the path to the logo
        Image _icon = new Image(Objects.requireNonNull(Main.class.getResource("ImageFiles/ApplicationIcon.png")).toString());
        //Sets the Icon of the window
        _stage.getIcons().add(_icon);
        //Sets the window to undecorated
        _stage.initStyle(StageStyle.UNDECORATED);
        //Makes the window not resizeable
        _stage.setResizable(false);
        //Sets the scene
        _stage.setScene(_scene);
        //Gets the controller from the _fxmlLoader
        BaseController _controller = _fxmlLoader.getController();
        //Calls the Initialize Method from the _controller
        _controller.Initialize();
    }

    //-----------------------------------------Load Methods-------------------------------------------------------------

    public static void LoadMainMenu(Pane _rootPage) {
        //Creates an instance of the FXMLLoader
        _fxmlLoader = new FXMLLoader(Main.class.getResource("FXMLFiles/MainMenu.fxml"));
        //Try-Catch used to catch any errors
        try{
            //Loads the fxml file and assigns it to the borderPane
            _pane = _fxmlLoader.load();
        }catch (Exception _e){
            //Displays a message to the console with the cause of the error
            System.out.println(_e.getCause());
            return; //Returns
        }
        //_sets all the children of the root pane to the borderPane
        _rootPage.getChildren().setAll(_pane);
        //Sets the title of the window
        _stage.setTitle("FishGame - Main Menu");
        //Shows the stage
        _stage.show();
        //Gets the controller from the _fxmlLoader
        MainMenuController _controller = _fxmlLoader.getController();
        //Calls the Initialize Method from the _controller
        _controller.Initialize(_rootPage);
    }

    public static void LoadHowToPlay(Pane _rootPage) {
        //Creates an instance of the FXMLLoader
        _fxmlLoader = new FXMLLoader(Main.class.getResource("FXMLFiles/HowToPlay.fxml"));
        //Try-Catch used to catch any errors
        try{
            //Loads the fxml file and assigns it to the borderPane
            _pane = _fxmlLoader.load();
        }catch (Exception _e){
            //Displays a message to the console with the cause of the error
            System.out.println(_e.getCause());
            return; //Returns
        }
        //_sets all the children of the root pane to the borderPane
        _rootPage.getChildren().setAll(_pane);
        //Sets the title of the window
        _stage.setTitle("FishGame - How To Play");
        //Gets the controller from the _fxmlLoader
        HowToPlayController _controller = _fxmlLoader.getController();
        //Calls the Initialize Method from the _controller
        _controller.Initialize(_rootPage);
    }

    public static void LoadLeaderboard(Pane _rootPage) {
        //Creates an instance of the FXMLLoader
        _fxmlLoader = new FXMLLoader(Main.class.getResource("FXMLFiles/Leaderboard.fxml"));
        //Try-Catch used to catch any errors
        try{
            //Loads the fxml file and assigns it to the borderPane
            _pane = _fxmlLoader.load();
        }catch (Exception _e){
            //Displays a message to the console with the cause of the error
            System.out.println(_e.getCause());
            return; //Returns
        }
        //_sets all the children of the root pane to the borderPane
        _rootPage.getChildren().setAll(_pane);
        //Sets the title of the window
        _stage.setTitle("FishGame - Leaderboard");
        //Gets the controller from the _fxmlLoader
        LeaderboardController _controller = _fxmlLoader.getController();
        //Calls the Initialize Method from the _controller
        _controller.Initialize(_rootPage);
    }

    public static void LoadGameInitializer(Pane _rootPage) {
        //Creates an instance of the FXMLLoader
        _fxmlLoader = new FXMLLoader(Main.class.getResource("FXMLFiles/GameInitializer.fxml"));
        //Try-Catch used to catch any errors
        try{
            //Loads the fxml file and assigns it to the borderPane
            _pane = _fxmlLoader.load();
        }catch (Exception _e){
            //Displays a message to the console with the cause of the error
            System.out.println(_e.getCause());
            return; //Returns
        }
        //_sets all the children of the root pane to the borderPane
        _rootPage.getChildren().setAll(_pane);
        //Sets the title of the window
        _stage.setTitle("FishGame - Initializer");
        //Gets the controller from the _fxmlLoader
        GameInitializerController _controller = _fxmlLoader.getController();
        //Calls the Initialize Method from the _controller
        _controller.Initialize(_rootPage);
    }

    public static void LoadGame(Pane _rootPage, String _gamertag, String _country, PopulationSimulator _simulator) {
        //Creates an instance of the FXMLLoader
        _fxmlLoader = new FXMLLoader(Main.class.getResource("FXMLFiles/Game.fxml"));
        //Try-Catch used to catch any errors
        try{
            //Loads the fxml file and assigns it to the borderPane
            _pane = _fxmlLoader.load();
        }catch (Exception _e){
            //Displays a message to the console with the cause of the error
            System.out.println(_e.getCause());
            return; //Returns
        }
        //_sets all the children of the root pane to the borderPane
        _rootPage.getChildren().setAll(_pane);
        //Sets the title of the window
        _stage.setTitle("FishGame - Game");
        //Shows the stage
        _stage.show();
        //Gets the controller from the _fxmlLoader
        GameController _controller = _fxmlLoader.getController();
        //Calls the Initialize Method from the _controller
        _controller.Initialize(_rootPage, _gamertag, _country, _simulator);
    }

    public static void LoadEndGame(Pane _rootPage, String _gamertag, String _country, BigDecimal _guess, BigDecimal _answer, double _percentageError) {
        //Creates an instance of the FXMLLoader
        _fxmlLoader = new FXMLLoader(Main.class.getResource("FXMLFiles/EndGame.fxml"));
        //Try-Catch used to catch any errors
        try{
            //Loads the fxml file and assigns it to the borderPane
            _pane = _fxmlLoader.load();
        }catch (Exception _e){
            //Displays a message to the console with the cause of the error
            System.out.println(_e.getCause());
            return; //Returns
        }
        //_sets all the children of the root pane to the borderPane
        _rootPage.getChildren().setAll(_pane);
        //Sets the title of the window
        _stage.setTitle("FishGame - Results");
        //Shows the stage
        _stage.show();
        //Gets the controller from the _fxmlLoader
        EndGameController _controller = _fxmlLoader.getController();
        //Calls the Initialize Method from the _controller
        _controller.Initialize(_rootPage, _gamertag, _country, _guess, _answer, _percentageError);
    }
}
