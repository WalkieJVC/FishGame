package com.fishgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class GameController extends BaseController{
    //Variables
    private String _gamertag;
    private String _country;
    private Population _population;

    //FXML Related Variables
    @FXML
    TextField _guessNumberField;
    @FXML
    Label _guessingDayLabel;
    @FXML
    Label _initialPopulation;
    @FXML
    Label _finalPopulation;
    @FXML
    Label _messageLabel;

    //Initialize Method
    public void Initialize(Pane _rootPage, String _gamertag, String _country, PopulationSimulator _simulator) {
        //Initializes the variables of this instance with the values of the parameters
        this._rootPage = _rootPage;
        this._gamertag = _gamertag;
        this._country = _country;

        //Calls the SimulatePopulation method from the _simulator instance
        _population = _simulator.SimulatePopulation();

        //Displays the day in which you need to guess the population of the fish
        _guessingDayLabel.setText(String.valueOf(_population.getGuessingDay()));

        //Displays the population count on day 1
        _initialPopulation.setText("Population on day 1: " + _population.getTotalOnInitialDay().toString());
        //Displays the population count on day final day
        _finalPopulation.setText("Population on day " + _population.getFinalDay() + ": " + _population.getTotalOnFinalDay().toString());
    }

    @FXML //MakeGuess Method
    private void MakeGuess() {
        //Local Variable
        BigDecimal _answer;         //Holds the value for the answer
        BigDecimal _guess;          //Holds the value for the guess
        double _percentageError;    //Holds the value of the percentage error

        //Initializes an instance of the validator class and passes a regex as its parameter
        Validator<String> _validator = new Validator<>("\\d+");

        //Checks if the input by the user is valid based on the regex
        if (!_validator.IsStringValid(_guessNumberField.getText())){
            //Displays a message
            _messageLabel.setText("ERROR - Field Cannot Be Empty and It Must Be a Whole Number");
            return; //Returns
        }

        //Gets the number from the text field and assigns it to _guess
        _guess = BigDecimal.valueOf(Long.parseLong(_guessNumberField.getText()));

        if (_guess.compareTo(_population.getTotalOnFinalDay()) == 1){
            _messageLabel.setText("Hint: Your Answer is less that the number of fishes on day 50. Try again!");
            return; //Returns
        }

        //Gets the answer From the population object
        _answer = _population.getTotalOnGuessingDay();

        //Calls the CalculatePercentageError Method and passes the _guess and _answer variables as parameters
        _percentageError = CalculatePercentageError(_guess, _answer);

        //Calls the LoadEndGame Method from the SceneManager and passes the _rootPage, _gamertag, _country, _guess, _answer, _percentageError as parameters
        SceneManager.LoadEndGame(_rootPage, _gamertag, _country, _guess, _answer, _percentageError);
    }

    //CalculatePercentageError Method
    private double CalculatePercentageError(BigDecimal _guess, BigDecimal _answer){
        //Local Variable
        double _percentageError; //Holds the value of the calculated Percentage Error
        BigDecimal _subtraction; //Holds the value of the initial subtraction

        //Calls the subtract Method from the BigDecimal class and passes _answer as its variable. The returned value is assigned to _subtraction
        _subtraction = _guess.subtract(_answer);

        //Checks if the subtraction is equal to 0
        if(_subtraction.equals(BigDecimal.valueOf(0))){
            return 0; //Returns 0
        }

        //Calculates the percentage error using the following formula and the result is assigned to _percentageError
            //|((_guess - _answer) / _answer) * 100%|
        _percentageError = Double.parseDouble(String.valueOf(_subtraction.divide(_answer, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100)).abs()));

        return _percentageError; //Returns the percentage error
    }

    @FXML //Clear Method
    private void Clear(){
        //Clears the text field
        _guessNumberField.clear();
        //Clears the message label
        _messageLabel.setText("");
    }
}
