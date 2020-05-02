package com.ghostbusters.game.Input.Handlers.Impl;

import com.ghostbusters.game.GameController;
import com.ghostbusters.game.Input.Handlers.InputProvider;

import java.util.List;

public class AggregatedInput implements InputProvider {
    private final List<InputProvider> inputProviders;

    public AggregatedInput(List<InputProvider> inputProviders){
        this.inputProviders = inputProviders;
    }

    @Override
    public GameController GetController() {
        GameController gameController = new GameController();

        for (InputProvider currentInputProvider: inputProviders) {
            GameController currentGameController = currentInputProvider.GetController();

            this.CopyTrueValues(currentGameController, gameController);
        }

        return gameController;
    }

    void CopyTrueValues(GameController source, GameController destination)
    {
        if (source.Up)
        {
            destination.Up = true;
        }

        if (source.Down)
        {
            destination.Down = true;
        }

        if (source.Left)
        {
            destination.Left = true;
        }

        if (source.Right)
        {
            destination.Right = true;
        }

        if (source.Exit)
        {
            destination.Exit = true;
        }
    }
}
