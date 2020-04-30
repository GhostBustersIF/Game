package com.ghostbusters.game;

import com.ghostbusters.game.Configs.GameConfig;
import com.ghostbusters.game.Structures.GameState;

public class GameManager {
    GameState state = GameState.Menu;
    World world;

    public GameManager() {
        this.world = new World();
    }

    public GameState GetState() {
        return this.state;
    }

    public void ProcessInput(GameController controller) {
        world.ProcessInput(controller);
    }

    public void Update() {
        world.Update();

        if (world.isGameOver) {
            state = GameState.Exit;
        }
    }

    public void Repaint(GameGraphics g2d) {
        world.Repaint(g2d);
    }

    public void Initialize(GameConfig config) {
        this.world.Initialize(config);
        this.state = GameState.Game;
    }
}
