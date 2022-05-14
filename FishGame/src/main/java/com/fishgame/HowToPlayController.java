package com.fishgame;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HowToPlayController extends BaseController{
    public void Initialize(Pane _rootPage) {
        this._rootPage = _rootPage;
    }

    @FXML //ToHowToPage Method
    private void ToMainMenuPage(){
        //Cals the LoadHowToPlay method from the scene manager and passes the _rootPage as a parameter
        SceneManager.LoadMainMenu(_rootPage);
    }
}
