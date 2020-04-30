package com.ghostbusters.game.Actions;

import com.ghostbusters.game.GameObjects.GameMap;
import com.ghostbusters.game.GameObjects.Player;
import com.ghostbusters.game.GameObjects.Tile;
import com.ghostbusters.game.Structures.Direction;
import com.ghostbusters.game.Structures.Position;
import com.ghostbusters.game.World;

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
        int newX = position.X;
        int newY = position.Y;

        if (direction == Direction.Left) newX -= this.player.velocity;
        if (direction == Direction.Right) newX += this.player.velocity;
        if (direction == Direction.Up) newY -= this.player.velocity;
        if (direction == Direction.Down) newY += this.player.velocity;

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

        this.player.position = newPosition;
    }
}
