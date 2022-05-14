package com.fishgame;

import java.math.BigDecimal;

public class Population {
    //Variables
    private final int _guessingDay;                   //Holds the value for the guessing day
    private final int _finalDay;                      //Holds the value for the final day
    private final BigDecimal _totalOnInitialDay;      //Holds the value for the total on initial day
    private final BigDecimal _totalOnFinalDay;        //Holds the value for the total on final day
    private final BigDecimal _totalOnGuessingDay;     //Holds the value for the total on guessing day

    //Constructor
    public Population (int _guessingDay, int _finalDay, BigDecimal _totalOnInitialDay, BigDecimal _totalOnFinalDay, BigDecimal _totalOnGuessingDay)
    {
        //Assigns the parameter values to their respected variables of this instance
        this._guessingDay = _guessingDay;
        this._finalDay = _finalDay;
        this._totalOnInitialDay = _totalOnInitialDay;
        this._totalOnFinalDay = _totalOnFinalDay;
        this._totalOnGuessingDay = _totalOnGuessingDay;
    }

    //Getters
    public int getGuessingDay(){return this._guessingDay;}                          //Returns the value of _guessingDay
    public int getFinalDay(){return this._finalDay;}                                //Returns the value of _finalDay
    public BigDecimal getTotalOnInitialDay(){return this._totalOnInitialDay;}       //Returns the value of _totalOnInitialDay
    public BigDecimal getTotalOnFinalDay(){return this._totalOnFinalDay;}           //Returns the value of _totalOnFinalDay
    public BigDecimal getTotalOnGuessingDay(){return this._totalOnGuessingDay;}     //Returns the value of _totalOnGuessingDay
}
