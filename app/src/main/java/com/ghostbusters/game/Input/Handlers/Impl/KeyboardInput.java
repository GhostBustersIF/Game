package com.ghostbusters.game.Input.Handlers.Impl;

import com.ghostbusters.framework.Input;
import com.ghostbusters.game.GameController;
import com.ghostbusters.game.Input.Handlers.InputProvider;

public class KeyboardInput implements InputProvider {

    private final Input input;
    private GameController gameController = new GameController();

    public KeyboardInput(Input input) {
        this.input = input;
    }

    @Override
    public GameController GetController() {
        for (Input.KeyEvent keyEvent: input.getKeyEvents()) {
            boolean isPressed = keyEvent.type == Input.KeyEvent.KEY_DOWN;
            ProcessKeyEvent(keyEvent.keyCode, isPressed);
        }

        return gameController;
    }

    private void ProcessKeyEvent(Integer keyCode, boolean isPressed) {
        switch (keyCode) {
            case 19: // ArrowUp
                gameController.Up = isPressed;
                break;
            case 20: // ArrowDown
                gameController.Down = isPressed;
                break;
            case 21: // ArrowLeft
                gameController.Left = isPressed;
                break;
            case 22: // ArrowRight
                gameController.Right = isPressed;
                break;
            case 45: // q
            case 33: // e
            case 67: // BackSpace
                gameController.Exit = isPressed;
                break;
            default:
                break;
        }
    }
}

