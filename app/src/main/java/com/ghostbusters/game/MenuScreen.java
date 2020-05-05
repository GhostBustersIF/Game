package com.ghostbusters.game;

import android.graphics.Color;

import com.ghostbusters.framework.Game;
import com.ghostbusters.framework.Input;
import com.ghostbusters.framework.Screen;
import com.ghostbusters.game.GameObjects.GameButton;
import com.ghostbusters.game.Input.GameInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuScreen extends Screen {
    private enum ButtonType{Start, HighScore, Options, Exit}
    Map<ButtonType,GameButton> gameButtons = new HashMap<>();


    public MenuScreen(Game game) {
        super(game);
        gameButtons.put(ButtonType.Start, new GameButton(140,10,50,50, Color.BLUE));
        gameButtons.put(ButtonType.HighScore, new GameButton(140,120,50,50, Color.BLUE));
        gameButtons.put(ButtonType.Options, new GameButton(140,230,50,50, Color.BLUE));
        gameButtons.put(ButtonType.Exit,new GameButton(140,340,50,50, Color.BLUE));
    }

    @Override
    public void update(float deltaTime) {
        for(Map.Entry<ButtonType, GameButton> pair: gameButtons.entrySet()){
            GameButton gameButton = pair.getValue();
            gameButton.Update(game);
            if(gameButton.isPressed()){
                this.clicked(pair.getKey());
            }
        }
    }

    private void clicked(ButtonType key) {
        switch (key){
            case Start:
            case Exit:
            case Options:
            case HighScore:
                game.setScreen(new GameScreen(game));
                break;
        }
    }

    @Override
    public void present(float deltaTime) {
        List<Input.TouchEvent> list = game.getInput().getTouchEvents();
        for(GameButton gameButton: gameButtons.values()){
            gameButton.ProcessInput(list);
            gameButton.Repaint(game.getGraphics());
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
