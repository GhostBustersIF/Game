package com.ghostbusters.game.Actions;

import com.ghostbusters.game.GameObjects.Enemy;
import com.ghostbusters.game.GameObjects.GameMap;
import com.ghostbusters.game.GameObjects.Player;
import com.ghostbusters.game.GameObjects.Tile;
import com.ghostbusters.game.Structures.Direction;
import com.ghostbusters.game.Structures.Position;
import com.ghostbusters.game.World;

import java.util.List;

public class MoveAction implements GameAction {
    private final Enemy enemy;
    private final Direction direction;

    public MoveAction(Enemy enemy, Direction direction) {
            this.enemy = enemy;
            this.direction = direction;
        }

    @Override
    public void Execute(World world) {
        this.enemy.direction = direction;
        Position position = this.enemy.position;
        int newX = position.X;
        int newY = position.Y;

        if (direction == Direction.Left) newX -= this.enemy.velocity;
        if (direction == Direction.Right) newX += this.enemy.velocity;
        if (direction == Direction.Up) newY -= this.enemy.velocity;
        if (direction == Direction.Down) newY += this.enemy.velocity;

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

        List<Player> players = map.GetPlayers(newPosition);
        if (!players.isEmpty()){
            for (Player player: players) {
                world.processAction(new KillPlayerAction(this.enemy, player));
                return;
            }
        }

        this.enemy.position = newPosition;
    }
}
