package com.fishgame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Generic Class
public class Validator <T extends String> {

    //Class variables
    private final T _regexObj;            //Used to store the pattern

    //Constructor
    public Validator(String _regexObj){
        //Assigns the parameter value to the variable of this instance
        this._regexObj = (T) _regexObj;
    }

    //IsStringValid Method
    public boolean IsStringValid(String _string)
    {
        //local variables
        Pattern _pattern;
        Matcher _matcher;

        //Compiles the pattern
        _pattern = Pattern.compile(_regexObj);

        //Adds the email to _matcher.
        _matcher = _pattern.matcher(_string);

        //Returns the result of the match
        return _matcher.matches();
    }
}
