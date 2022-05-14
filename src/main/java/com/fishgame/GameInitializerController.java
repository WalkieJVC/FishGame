package com.fishgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.Random;

public class GameInitializerController extends BaseController{
    //Variables
    Validator<String> _validator;                       //Validator Object
    QueryHandler _queryHandler = new QueryHandler();    //QueryHandler Object (Initialized)
    String _gamertag;                                   //String to hold the gamertag
    String _country;                                    //String to hold the country
    int _populationsCount;                              //Holds the populationID

    PopulationSimulator _simulator;
    Random _randomGenerator = new Random();

    int _populationID;
    int _finalDay;
    int _guessingDay;

    //FXML Related Variables
    @FXML
    private TextField _gamertagField;
    @FXML
    private ComboBox _countryField;
    @FXML
    private Label _messageLabel;
    @FXML
    public Label _countryLabel;

    //Initialize Method
    public void Initialize(Pane _rootPage) {
        //Assigns the _rootPage to the _rootPage of this class
        this._rootPage = _rootPage;
        //Populates the _countryField ComboBox
        _countryField.getItems().addAll(_queryHandler.CallGetAllCountries());

        //Deselects the TextField when it initializes
        _gamertagField.setFocusTraversable(false);

        //Calls the CallGetPopulationsCount from the Query Handler and the returned value is assigned to _populationsCount
        _populationsCount = _queryHandler.CallGetPopulationsCount();

        //Change Latter For Difficulty Settings
        _finalDay = 50;

        //Generates a random number within the range of 1 and _populationsCount and assigns it to _populationID
        _populationID = _randomGenerator.nextInt(_populationsCount - 1 + 1) + 1;
        //Generates a random number within the range of 10 and _finalDay - 1 and assigns it to _guessingDay
        _guessingDay = _randomGenerator.nextInt((_finalDay - 1) - 10 + 1) + 10;

        //Creates a new instance of PopulationSimulator by calling the constructor and passing the _finalDay, _guessingDay, _populationID as parameters
        _simulator = new PopulationSimulator(_finalDay, _guessingDay, _populationID);
    }

    @FXML //ToGamePage Method
    private void ToGamePage() {
        //Checks if the any of the fields is empty
        if (_gamertagField.getText().equals("") || _countryField.getSelectionModel().getSelectedItem() == null){
            //Displays a message
            _messageLabel.setText("All Fields Must Be Filled");
            return; //Returns
        }

        //Gets the gamertag from the _gamertagField in lowercase and the value is assigned to _gamertag
        _gamertag = _gamertagField.getText().toLowerCase();
        //Gets the country from the _countryField and the value is assigned to _country
        _country = _countryField.getSelectionModel().getSelectedItem().toString();

        //Creates a new instance of the validator object and the regex is passed as a parameter for the constructor
        _validator = new Validator<>("^[a-zA-Z0-9]{5,25}$");

        //Checks if the gamertag is valid
        if(!_validator.IsStringValid(_gamertag)){
            //Displays a message
            _messageLabel.setText("Gamertag is not valid");
            return; //Returns
        }
        //Calls the LoadGame Method from the scene manager and passes the _rootPage, _gamerTag, and _country as the parameters
        SceneManager.LoadGame(_rootPage, _gamertag, _country, _simulator);
    }

    @FXML //ToMainMenuPage Method
    private void ToMainMenuPage(){SceneManager.LoadMainMenu(_rootPage);} //Calls the LoadMainMenu Method from the SceneManager and passes the _rootPage as a parameter

    @FXML //Select Method
    private void Select(ActionEvent _e) {
        //Local Variables
        final Node source = (Node) _e.getSource(); //Node used to get the id from the source to compare
        String id = source.getId();                //Holds the value for the ID as a string

        //Checks if the id from the source is equal to _vehicleSize
        if (id.equals("_sizesField")) {
            //Sets the vehicle size label text
            _countryLabel.setText("");
            return; //Returns
        }
    }

    @FXML //RotateArrow Method
    private void RotateArrow(MouseEvent _e) {
        //Checks if the source of the mouse event is the _vehicle size comboBox
        if (_countryField.equals(_e.getSource())) {
            //Calls the rotate method and passes the vehicle, and the angle to rotate
            Rotate(_countryField, 20);
            return; //Returns
        }
    }

    @FXML //ResetArrow Method
    private void ResetArrow(MouseEvent _e) {
        //Checks if the source of the mouse event is the _vehicle size comboBox
        if (_countryField.equals(_e.getSource())) {
            //Calls the rotate method and passes the vehicle, and the angle to rotate
            Rotate(_countryField, 0);
            return; //Returns
        }
    }

    //Rotate Method
    private void Rotate(ComboBox<String> _comboBox , int _angle) {
        //Adds a rotating effect to the dropdown arrow in the combo box
        _comboBox.lookup(".arrow-button").setStyle("-fx-rotate: " + _angle + ";");
    }

    //Clear Method
    @FXML
    private void Clear(){
        //Clears the gamertag text field
        _gamertagField.clear();
        //Clears the combo box selection
        _countryField.getSelectionModel().clearSelection();
        //Clears the message label
        _messageLabel.setText("");

        //Sets the country label to display Country
        _countryLabel.setText("Country");
    }
}
