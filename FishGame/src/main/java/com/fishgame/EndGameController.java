package com.fishgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.math.BigDecimal;

public class EndGameController extends BaseController{
    //Variables
    QueryHandler _queryHandler = new QueryHandler();
    EndGameRecords _records;

    //FXML Related Variables
    @FXML
    Label _finalMessageLabel;
    @FXML
    Label _percentageAverageLabel;
    @FXML
    Label _guessAndAnswerLabel;
    @FXML
    Label _scoreLabel;
    @FXML
    Label _personalBestLabel;
    @FXML
    Label _localBestLabel;
    @FXML
    Label _worldWideBestLabel;

    //Initialize Method
    public void Initialize(Pane _rootPage, String _gamertag, String _country, BigDecimal _guess, BigDecimal _answer, double _percentageError) {
        //Local Variables
        String _congrats = "Congratulations " + _gamertag + "!";
        String _notGoodEnough = "Better Luck Next Time " + _gamertag + " :(";

        //Initializes the rootPage variable of this instance with the rootPage variable passed as a parameter
        this._rootPage = _rootPage;

        //Calls the CallInsertNewAttempt Method from the query handler and passes the _gamertag, _country, _percentageError. The returned object is assigned to _records
        _records = _queryHandler.CallInsertNewAttempt(_gamertag, _country, _percentageError);


        if (_percentageError == _records.getWorldBest()){ //Checks if the percentage error equal the world record
            //Calls the DisplayMessage Method and passes the _congrats String and a custom message
            DisplayMessage(_congrats, "You Set The New World Record!");
        } else if (_percentageError == _records.getPersonalBest()){ //Checks if the percentage error equal the personal best
            //Calls the DisplayMessage Method and passes the _congrats String and a custom message
            DisplayMessage(_congrats, "You Set A New Personal Best!");
        }else if (_percentageError < 20){ //Checks if the percentage is less that 20%
            //Calls the DisplayMessage Method and passes the _congrats String and a custom message
            DisplayMessage(_congrats, "You Scored Below 20%");
        } else { //Else
            //Calls the DisplayMessage Method and passes the _notGoodEnough String and a custom message
            DisplayMessage(_notGoodEnough, "You Scored Above 20%");
        }

        //Displays the end game data
        _guessAndAnswerLabel.setText("You guessed: " + _guess + " and the correct answer was: " + _answer);     //The number you guessed and the correct answer
        _scoreLabel.setText("Your Score: " + _percentageError + "%");                                           //The Percentage Error
        _personalBestLabel.setText("Your Highest Score: " + _records.getPersonalBest() + "%");                  //Personal Highest Score
        _localBestLabel.setText("National Highest Score: " + _records.getNationalBest() + "%");                 //National Highest Score
        _worldWideBestLabel.setText("World Highest Score: " + _records.getWorldBest() + "%");                   //WorldWide Highest Score
    }

    //DisplayCongrats Message
    private void DisplayMessage(String _finalMessage, String _percentageAverage){
        //Sets the final message
        _finalMessageLabel.setText(_finalMessage);
        //Sets the percentage average message
        _percentageAverageLabel.setText(_percentageAverage);
    }

    @FXML //ToGameInitializerPage Method
    public void ToGameInitializerPage(){
        //Calls the LoadGameInitializer Method from the scene manager and passes the _rootPage as a parameter
        SceneManager.LoadGameInitializer(_rootPage);
    }

    @FXML //ToMainMenuPage Method
    public void ToMainMenuPage() {
        //Calls the LoadMainMenu Method from the scene manager and passes the _rootPage as a parameter
        SceneManager.LoadMainMenu(_rootPage);
    }
}




