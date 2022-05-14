package com.fishgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class LeaderboardController extends BaseController{
    //Variables
    QueryHandler _queryHandler = new QueryHandler();
    ArrayList<TableObject> _tableObjects;

    //FXML Related Variables
    @FXML
    TableView<TableObject> _table;
    @FXML
    TableColumn<TableObject, String> _placementColumn;
    @FXML
    TableColumn<TableObject, String> _gamertagColumn;
    @FXML
    TableColumn<TableObject, String> _countryColumn;
    @FXML
    TableColumn<TableObject, Double> _scoreColumn;

    public void Initialize(Pane _rootPage){
        //Assigns the _rootPage to the _rootPage of this class
        this._rootPage = _rootPage;
        //Sets a new label as the placeholder text for the table
        _table.setPlaceholder(new Label("No Current Records"));

        //Calls the CallGetTopTwenty method from the query handler and the returned arraylist gets assigned to _tableObjects
        _tableObjects = _queryHandler.CallGetTopTwenty();

        //Calls the PopulateTable Method
        PopulateTable();
    }

    //PopulateTable Method
    private void PopulateTable(){
        //For-Loop to iterate through every TableObject in _tableObjects
        for(TableObject _obj: _tableObjects)
        {
            //Sets the cell factory value for every column in the table
            _placementColumn.setCellValueFactory(new PropertyValueFactory<>("Placement"));
            _gamertagColumn.setCellValueFactory(new PropertyValueFactory<>("Gamertag"));
            _countryColumn.setCellValueFactory(new PropertyValueFactory<>("Country"));
            _scoreColumn.setCellValueFactory(new PropertyValueFactory<>("Score"));

            _table.getItems().add(_obj); //Adds the object to the table
            _table.getSortOrder().add(_placementColumn); //Sorts the Table By LocationID
        }
        _table.setSelectionModel(null); //Sets the selection model to null
    }

    @FXML //ToHowToPage Method
    private void ToMainMenuPage(){
        //Cals the LoadHowToPlay method from the scene manager and passes the _rootPage as a parameter
        SceneManager.LoadMainMenu(_rootPage);
    }
}
