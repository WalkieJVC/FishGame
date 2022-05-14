package com.fishgame;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class QueryHandler {
    //Connection
    private Connection _connection;
    //Callable Statement
    private CallableStatement _callableStatement;
    //ResultSet
    private ResultSet _output;
    //Stored Procedure String
    private String _procedure;

    /*----------------------------------------- Pre-Defined Calls ----------------------------------------------------*/
    //CallGetAllCountries Method
    public ArrayList<String> CallGetAllCountries() {
        //Local Variable
        ArrayList<String> _countries = new ArrayList<>();         //Initializes the ArrayList
        //Initializes the procedure String
        _procedure = "call `fishgame`.`GetAllCountries` ();";

        //Calls the ExecuteQuery Method and passes the stored procedure string as a parameter, the returned value gets assigned to _output.
        _output = ExecuteQuery(_procedure);

        //Try-Catch to catch any errors
        try {
            //While-Loop used to loop through the result sell while it has a next
            while (_output != null && _output.next()){
                //Adds the country to the list
                _countries.add(_output.getString("Country"));
            }
        }catch (Exception _e){
            //Displays an error message
            System.out.println("Unable To Populate Arraylist From Output - ERROR: " + _e.getCause());
            //Calls the CloseConnection Method
            CloseConnection();
            return null; //Returns null
        }
        //Calls the CloseConnection Method
        CloseConnection();
        return _countries; //Returns the arraylist
    }

    public int CallGetPopulationsCount() {
        //Local Variable
        int _populationsCount = 0;  //Initialized to 0
        //Initializes the procedure String
        _procedure = "call `fishgame`.`GetPopulationsCount` ();";

        //Calls the ExecuteQuery Method and passes the stored procedure string as a parameter, the returned value gets assigned to _output.
        _output = ExecuteQuery(_procedure);

        //Try-Catch to catch any errors
        try {
            //Checks if the output is not null and if it has a next
            if (_output != null && _output.next()){
                //Gets the population count from column Count and assigns the value to _populationsCount
                _populationsCount = _output.getInt("Count");
            }
        }catch (Exception _e){
            //Displays an error message
            System.out.println("Unable To Extract Population Count From ResultSet - ERROR: " + _e.getCause());
            CloseConnection(); //Calls the CloseConnection Method
        }
        //Calls the CloseConnection Method
        CloseConnection();
        return _populationsCount; //Returns the population count
    }

    public HashMap<Integer, BigDecimal> CallGetPopulation(int _populationID) {
        //Local Variable
        HashMap<Integer, BigDecimal> _population = new HashMap<>();
        //Initializes the procedure String
        _procedure = "call `fishgame`.`GetPopulation` (" + _populationID + ");";

        //Calls the ExecuteQuery Method and passes the stored procedure string as a parameter, the returned value gets assigned to _output.
        _output = ExecuteQuery(_procedure);

        //Try-Catch to catch any errors
        try {
            //Checks if the output is not null and if it has a next
            if (_output != null && _output.next()){
                for (int i = 0; i <= 8; i++)
                {
                    _population.put(i, BigDecimal.valueOf(_output.getInt("Counter"+ i +"")));
                }
            }
        }catch (Exception _e){
            //Displays an error message
            System.out.println("Unable To Extract Population Data From ResultSet - ERROR: " + _e.getCause());
            CloseConnection(); //Calls the CloseConnection Method
            return null; //Returns null
        }
        //Calls the CloseConnection Method
        CloseConnection();
        return _population; //Returns the population
    }

    public EndGameRecords CallInsertNewAttempt(String _gamertag, String _country, double _percentageError) {
            //Local Variables
        EndGameRecords _records = null;     //EndGameRecords Object
        double _personalBest;               //Personal Best variable
        double _localBest;                  //Local Best Variable
        double _worldWideBest;              //WorldWide Best Variable

        //Initializes the procedure String
        _procedure = "call `fishgame`.`InsertNewAttempt` ('" + _gamertag + "','" + _country + "'," + _percentageError + ");";

        //Calls the ExecuteQuery Method and passes the stored procedure string as a parameter, the returned value gets assigned to _output.
        _output = ExecuteQuery(_procedure);

        //Try-Catch to catch any errors
        try {
            //Checks if the output is not null and if it has a next
            if (_output != null && _output.next())
            {
                //Extract the information from the output and assigns it to their respected variables
                _personalBest = Double.parseDouble(_output.getString("PersonalBest"));
                _localBest = Double.parseDouble(_output.getString("NationalBest"));
                _worldWideBest = Double.parseDouble(_output.getString("WorldwideBest"));

                //Creates a new instance of records and passes the data as parameters for the constructor
                _records = new EndGameRecords(_personalBest, _localBest, _worldWideBest);
            }
        }catch (Exception _e){
            //Displays an error message
            System.out.println("Unable To Extract Information From ResultSet - ERROR: " + _e.getCause());
            return null; //Returns null
        }
        return _records; //Returns the records object
    }

    public ArrayList<TableObject> CallGetTopTwenty() {
        //Initializes the procedure String
        _procedure = "call `fishgame`.`GetTopTwenty` ();";
        //Calls the ExecuteQuery Method and passes the stored procedure string as a parameter, the returned value gets assigned to _output.
        _output = ExecuteQuery(_procedure);

        //Try-Catch to catch any errors
        try {
            //Returns the returned value from the PopulateTableObjects Method
            return PopulateTableObjects();
        }catch (Exception _e){
            //Displays an error message
            System.out.println("Unable to Populate Arraylist Table Object - ERROR: " + _e.getCause());
            return null; //Returns null
        }
    }

    /*----------------------------------------- Private methods ------------------------------------------------------*/
    //PopulateTableObjects Method
    private ArrayList<TableObject> PopulateTableObjects(){
        //TableObject
        ArrayList<TableObject> _objs = new ArrayList<>();

        //Try-Catch
        try {
            //Loop to iterate through everything in the result set _output
            while (_output.next())
            {
                //Creates a new instance of TableObject and adds it to the _objs list
                _objs.add(new TableObject(
                        Integer.parseInt(_output.getString("Placement")),
                        _output.getString("Gamertag"),
                        _output.getString("Country"),
                        Double.parseDouble(_output.getString("Score"))
                ));
            }
        }catch (Exception _e){
            //Displays an error message
            System.out.println("Unable to extract the values from the output - ERROR: " + _e.getCause());
            //Closes the Connection
            CloseConnection();
            return null; //Returns Null
        }

        //Closes the Connection
        CloseConnection();
        //Returns the objects
        return _objs;
    }

    /*----------------------------------------- Custom Query Calls ---------------------------------------------------*/
    //Execute Method
    private void Execute(String _query) {
        //Establish a connection
        EstablishConnection();
        try{
            //Prepares the call and assigns the returned value to the _callableStatement variable
            _callableStatement = _connection.prepareCall(_query);
            //Executes the Store Procedure
            _callableStatement.execute();
        }catch (Exception _e){
            //Close the connection
            CloseConnection();
            return; //returns
        }
        //Close the connection
        CloseConnection();
    }

    //ExecuteQuery Method
    private ResultSet ExecuteQuery(String _query) {
        //Establish a connection
        EstablishConnection();

        try {
            //Prepares the call and assigns the returned value to the _callableStatement variable
            _callableStatement = _connection.prepareCall(_query);
            //Executes the Store Procedure and returns the returned value
            return _callableStatement.executeQuery();
        }catch (Exception _e){
            //Displays an error message
            System.out.println("Unable Execute Query - ERROR : " + _e.getCause());
            //Calls the CloseConnection Method
            CloseConnection();
            return null; //Returns null
        }
    }

    /*----------------------------------------- Connection Methods ---------------------------------------------------*/
    //EstablishConnection Method
    private void EstablishConnection() {
        //Local Variables
        String _databaseName = "FishGame";                                  //Database Name
        String _databaseUsername = "root";                                  //Database UserName
        String _databasePassword = "12.258.Games.By.Walkie.JVC.@!";         //Database Password
        String _url = "jdbc:mysql://localhost:3306/" + _databaseName;       //Database URL

        //Try-Catch
        try {
            //Sets the class for name
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Attempts to make a connection with the database
            _connection = DriverManager.getConnection(_url, _databaseUsername, _databasePassword);

        }catch (Exception _e) {
            //Displays an error message
            System.out.println("Unable To Establish Connection - ERROR: " + _e.getCause());
        }
    }

    //CloseConnection Method
    private void CloseConnection() {
        try {
            //Closes the connection
            _connection.close();
        }catch (Exception _e){
            //Displays an error message
            System.out.println("Unable To Close Connection - ERROR: " + _e.getCause());
        }
    }
}
