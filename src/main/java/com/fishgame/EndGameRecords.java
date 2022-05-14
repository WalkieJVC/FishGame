package com.fishgame;

public class EndGameRecords {
    //Variables
    double _personalBest;   //Hold the value of the personal best
    double _nationalBest;   //Hold the value of the  best
    double _worldBest;      //Hold the value of the  best

    //Constructor
    public EndGameRecords(double _personalBest,double _localBest,double _worldBest){
        //Assigns the parameter values to their respected variables of this instance
        this._personalBest = _personalBest;
        this._nationalBest = _localBest;
        this._worldBest = _worldBest;
    }

    //Getters
    public double getPersonalBest(){return this._personalBest;}     //Returns the value of _personalBest
    public double getNationalBest(){return this._nationalBest;}     //Returns the value of _nationalBest
    public double getWorldBest(){return this._worldBest;}           //Returns the value of _worldBest
}
