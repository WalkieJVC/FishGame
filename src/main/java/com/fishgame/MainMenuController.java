package com.fishgame;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


public class MainMenuController extends BaseController{

    //Initialize Method
    public void Initialize(Pane _rootPage){
        //Assigns the _rootPage parameter to the variable _rootPage of this instance
        this._rootPage = _rootPage;
    }

    @FXML //ToHowToPage Method
    private void ToGameInitializerPage() {
        //Cals the LoadHowToPlay method from the scene manager and passes the _rootPage as a parameter
        SceneManager.LoadGameInitializer(_rootPage);
    }

    @FXML //ToHowToPage Method
    private void ToLeaderboardPage() {
        //Cals the LoadHowToPlay method from the scene manager and passes the _rootPage as a parameter
        SceneManager.LoadLeaderboard(_rootPage);
    }

    @FXML //ToHowToPage Method
    private void ToHowToPage(){
        //Cals the LoadHowToPlay method from the scene manager and passes the _rootPage as a parameter
        SceneManager.LoadHowToPlay(_rootPage);
    }
}
