package com.ghostbusters.game.Actions;

import com.ghostbusters.game.GameObjects.Enemy;
import com.ghostbusters.game.GameObjects.GameMap;
import com.ghostbusters.game.GameObjects.Player;
import com.ghostbusters.game.GameObjects.Tile;
import com.ghostbusters.game.Structures.Direction;
import com.ghostbusters.game.Structures.Position;
import com.ghostbusters.game.World;

import java.util.List;

public class PlayerMoveAction implements GameAction {
    private final Player player;
    private final Direction direction;

    public PlayerMoveAction(Player actor, Direction direction) {
        this.player = actor;
        this.direction = direction;
    }

    @Override
    public void Execute(World world) {
        this.player.direction = direction;
        Position position = this.player.position;
        float newX = position.preciseX;
        float newY = position.preciseY;
        float distance = CalculateDistance(this.player.velocity,world);
        if (direction == Direction.Left) newX -= distance;
        if (direction == Direction.Right) newX += distance;
        if (direction == Direction.Up) newY -= distance;
        if (direction == Direction.Down) newY += distance;

        Position newPosition = position.MoveTo(newX, newY);

        GameMap map = world.GetMap();
        if (!map.IsInsideZone(newPosition))
        {
            return;
        }

        Tile tile = map.GetLandscape(newPosition);
        if (tile != null && !tile.IsWalkable())
        {
            return;
        }

        List<Enemy> enemies = map.GetUnits(newPosition);
        for(Enemy enemy: enemies){
            enemy.isDead=true;
        }
        this.player.position = newPosition;
    }

    private float CalculateDistance (int velocity, World world){
        return world.getDeltaTime() * velocity;
    }
}
