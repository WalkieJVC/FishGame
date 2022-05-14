package com.fishgame;

public class TableObject {
    //Variables
    private final int _placement;     //Holds the value of the placement
    private final String _gamertag;   //Holds the value of the gamertag
    private final String _country;    //Holds the value of the country
    private final double _score;      //Holds the value of the score

    //Constructor
    public TableObject(int _placement, String _gamertag, String _country, double _score){
        //Assigns the parameter values to their respected variables of this instance
        this._placement = _placement;
        this._gamertag = _gamertag;
        this._country = _country;
        this._score = _score;
    }

    //Getters
    public int getPlacement(){return this._placement;}     //Returns the value of _placement
    public String getGamertag(){return this._gamertag;}     //Returns the value of _gamertag
    public String getCountry(){return this._country;}       //Returns the value of _country
    public double getScore(){return this._score;}           //Returns the value of _score
}
