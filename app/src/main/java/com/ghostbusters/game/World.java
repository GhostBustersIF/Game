package com.ghostbusters.game;

import com.ghostbusters.game.Configs.GameConfig;
import com.ghostbusters.game.Actions.GameAction;
import com.ghostbusters.game.GameObjects.GameMap;

import java.util.List;

public class World {

    public boolean isGameOver = false;
    private GameMap map = new GameMap();

    public float getDeltaTime() {
        return deltaTime;
    }

    private float deltaTime;

    public World() {}

    public void ProcessInput(GameController gameController) {
        map.ProcessInput(gameController);
    }

    public void Update(float deltaTime) {
        this.deltaTime = deltaTime;
        map.Update(this);
    }

    public void Repaint(GameGraphics ui) {
        map.Repaint(ui);
    }

    public void processActions(List<GameAction> actions) {
        for (GameAction action: actions) {
            action.Execute(this);
        }
    }

    public void processAction(GameAction action) {
        action.Execute(this);
    }

    public GameMap GetMap() {
        return this.map;
    }

    public void GameOver() {
        isGameOver = true;
    }

    public void Initialize(GameConfig config) {
    }
}
