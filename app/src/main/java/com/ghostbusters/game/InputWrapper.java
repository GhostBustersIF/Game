package com.ghostbusters.game;

import com.ghostbusters.framework.Input;

import java.util.List;

public final class InputWrapper {

    public static GameController GetGameControllerInput(Input input) {
        List<Input.TouchEvent> touchEvents = input.getTouchEvents();
        List<Input.KeyEvent> keyEvents = input.getKeyEvents();
        //TODO: Add some logic
        GameController gameController = new GameController();
        return gameController;
    }
}
