package com.ghostbusters.game.Input.Handlers.Impl;

import android.util.Log;
import android.util.Pair;

import com.ghostbusters.framework.Input;
import com.ghostbusters.game.GameController;
import com.ghostbusters.game.Input.Handlers.InputProvider;

public class TouchInput implements InputProvider {

    private final Input input;
    private GameController gameController = new GameController();

    private Pair<Integer, Integer> touch;

    public TouchInput(Input input) {
        this.input = input;
    }

    @Override
    public GameController GetController() {
        for (Input.TouchEvent touchEvent: input.getTouchEvents()) {
            switch (touchEvent.type){
                case Input.TouchEvent.TOUCH_DOWN:
                    StartTouch(touchEvent);
                    break;
                case Input.TouchEvent.TOUCH_DRAGGED:
                    HandleTouch(touchEvent);
                    break;
                case Input.TouchEvent.TOUCH_UP:
                    FinishTouch(touchEvent);
                    break;
            }
        }

        return gameController;
    }

    private void StartTouch(Input.TouchEvent event) {
        this.touch = new Pair<>(event.x, event.y);
        Log.d(getClass().toString(), "START" + event.type + " " + touch.first + " " + touch.second);
    }

    private void HandleTouch(Input.TouchEvent event) {
        ProcessKeyEvent(event);
    }

    private void FinishTouch(Input.TouchEvent event) {
        gameController = new GameController();
        touch = null;
    }

    private void ProcessKeyEvent(Input.TouchEvent event) {
        if (touch == null || event == null){
            return;
        }

        Log.d(getClass().toString(), "-->" + event.type + " " + touch.first + " " + touch.second);

        if (event.x - touch.first > 10) {
            gameController.Left = false;
            gameController.Right = true;
        } else if (touch.first - event.x > 10) {
            gameController.Left = true;
            gameController.Right = false;
        } else {
            gameController.Left = false;
            gameController.Right = false;
        }

        if (event.y - touch.second > 10) {
            gameController.Up = false;
            gameController.Down = true;
        } else if (touch.second - event.y > 10) {
            gameController.Up = true;
            gameController.Down = false;
        } else {
            gameController.Up = false;
            gameController.Down = false;
        }
    }
}
