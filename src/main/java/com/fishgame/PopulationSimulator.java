package com.fishgame;

import java.math.BigDecimal;
import java.util.HashMap;

public class PopulationSimulator {
    //Variables
    private final QueryHandler _queryHandler = new QueryHandler();
    private final int _daysToSimulate;
    private final int _guessingDay;
    private final int _populationID;

    //Constructor
    public PopulationSimulator(int _daysToSimulate, int _guessingDay, int _populationID){
        //Assigns the parameter values to their respected variables of this instance
        this._daysToSimulate = _daysToSimulate;
        this._guessingDay = _guessingDay;
        this._populationID = _populationID;
    }

    //SimulatePopulation Method
    public Population SimulatePopulation() {
            //Local Variables
        BigDecimal _totalOnInitialDay;
        BigDecimal _totalOnFinalDay;
        //Hashmaps
        HashMap<Integer, BigDecimal> _totalFishes;
        HashMap<Integer, BigDecimal> _fishesToday;
        //BigDecimals
        BigDecimal _toAdd = BigDecimal.valueOf(0);
        BigDecimal _answer = BigDecimal.valueOf(0);

        //Calls the CallGetPopulation Method from the query handler and passes the _populationID as a parameter, the returned value is assigned to _totalFishes
        _totalFishes = _queryHandler.CallGetPopulation(_populationID);

        //Calls the AddTotal Method and passes the _totalFishes as a parameter, the returned value is assigned to _totalOnInitialDay
        _totalOnInitialDay = AddTotal(_totalFishes);

        //For-Loop to loop through the _daysToSimulate amount
        for (int i = 0; i < _daysToSimulate; i++){

            //Calls the GetEmptyMap Method and the returned value is assigned to _fishesToday
            _fishesToday = GetEmptyMap();

            //For-Loop to loop through all counters
            for (int k = 0; k <= 8; k++){
                //Checks if the counter equals 0
                if (k == 0)
                {
                    //Gets the value from the hashmap that has k at its key and assigns it to _toAdd
                    _toAdd = _totalFishes.get(k);
                } else {
                    //Puts the total fishes of counter k on the previous key
                    _fishesToday.put(k - 1, _totalFishes.get(k));
                }
            }

            //Adds what ever is in 6 plus _toAdd and that value is put into key 6
            _fishesToday.put(6, _fishesToday.get(6).add(_toAdd));
            //Puts _toAdd into key 8
            _fishesToday.put(8, _toAdd);

            //For-Loop to iterate through every counter and add it to the total number of fishes arraylist1
            for (int f = 0; f < _totalFishes.size(); f++) {
                _totalFishes.put(f, _fishesToday.get(f));
            }

            //Checks if it is the guessing day
            if(i == _guessingDay){
                //Calls the AddTotal Method and passes the _totalFishes Hashmap as a parameter, the returned value is assigned to _answer
                _answer = AddTotal(_totalFishes);
            }
        }

        //Calls the AddTotal Method and passes the _totalFishes Hashmap as a parameter, the returned value is assigned to _totalOnFinalDay
        _totalOnFinalDay = AddTotal(_totalFishes);

        //return a new instance of Population
        return new Population(_guessingDay, _daysToSimulate, _totalOnInitialDay, _totalOnFinalDay, _answer);
    }

    private BigDecimal AddTotal(HashMap<Integer, BigDecimal> _totalFishes){
        //Local Variable
        BigDecimal _total = BigDecimal.valueOf(0); //Initialized to 0

        //For-Loop to iterate through every key
        for (int _key: _totalFishes.keySet()){
            //Adds total plus the value stores with the key of _key and that is assigned to _total
            _total = _total.add(_totalFishes.get(_key));
        }

        return _total; //Returns the total
    }

    //GetEmptyMap Method
    private static HashMap<Integer, BigDecimal> GetEmptyMap() {

        //Initializes a new HashMap of Integer, BigDecimal
        HashMap <Integer, BigDecimal> _map = new HashMap<>();
        //For-Loop used to loop a total of 9 times
        for (int i = 0; i <= 8; i++){
            //Populates the hashmap with the key i and an empty value
            _map.put(i, BigDecimal.valueOf(0));
        }

        //Returns the _map
        return _map;
    }
}
