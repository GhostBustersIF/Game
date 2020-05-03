package com.ghostbusters.game.Input;

import com.ghostbusters.framework.Input;
import com.ghostbusters.game.GameController;
import com.ghostbusters.game.Input.Handlers.Impl.AggregatedInput;
import com.ghostbusters.game.Input.Handlers.Impl.KeyboardInput;
import com.ghostbusters.game.Input.Handlers.Impl.TouchInput;
import com.ghostbusters.game.Input.Handlers.InputProvider;

import java.util.ArrayList;
import java.util.List;

public final class GameInput {

    private final AggregatedInput aggregatedInput;
    private Input input;

    public GameInput(Input input) {
        this.input = input;
        List<InputProvider> inputs = new ArrayList<>();
        inputs.add(new KeyboardInput(input));
        inputs.add(new TouchInput(input));
        this.aggregatedInput = new AggregatedInput(inputs);
    }

    public GameController GetGameControllerInput() {
        GameController gameController = aggregatedInput.GetController();
        return gameController;
    }

    public List<Input.TouchEvent> GetTouchInput(){
        return input.getTouchEvents();
    }
}
