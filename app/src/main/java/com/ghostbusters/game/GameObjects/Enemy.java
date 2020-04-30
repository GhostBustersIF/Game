package com.ghostbusters.game.GameObjects;

import com.ghostbusters.game.Actions.GameAction;
import com.ghostbusters.game.Actions.MoveAction;
import com.ghostbusters.game.Assets;
import com.ghostbusters.game.GameController;
import com.ghostbusters.game.GameGraphics;
import com.ghostbusters.game.Structures.Direction;
import com.ghostbusters.game.Structures.Position;
import com.ghostbusters.game.World;

import java.util.ArrayList;
import java.util.List;

public class Enemy implements GameObject {
    public Position position = new Position(200, 200, 12, 12);
    public Direction direction = Direction.randomDirection();
    public int velocity = 6;

    private int stepsInSameDirection = 0;
    private int maxStepsInSameDirection = 10;
    private List<GameAction> actions = new ArrayList<>();

    @Override
    public void ProcessInput(GameController controller) {
        this.actions.clear();

        this.actions.add(new MoveAction(this, this.direction));
    }

    @Override
    public void Update(World world) {
        world.processActions(this.actions);

        if (stepsInSameDirection++ >= maxStepsInSameDirection) {
            this.direction = Direction.randomDirection();
            stepsInSameDirection = 0;
        }
    }

    @Override
    public void Repaint(GameGraphics ui) {
        ui.drawImage(Assets.ghost, this.position.X + 1, this.position.Y + 1);
    }
}
