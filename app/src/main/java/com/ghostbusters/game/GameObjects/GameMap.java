package com.ghostbusters.game.GameObjects;

import com.ghostbusters.game.GameController;
import com.ghostbusters.game.GameGraphics;
import com.ghostbusters.game.Structures.Position;
import com.ghostbusters.game.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class GameMap implements GameObject {
    private Position map = new Position(0, 0, 320, 480);//320/480
    private List<Player> players = new ArrayList<Player>();
    private List<Tile> tiles = new ArrayList<Tile>();
    private List<Enemy> units = new ArrayList<Enemy>();

    public GameMap() {
        tiles.add(new Tile());

        players.add(new Player());

//        units.add(new Enemy());
//        units.add(new Enemy());
//        units.add(new Enemy());
        for (int i = 0; i<3;i++){
            units.add(new Enemy());
        }


    }

    public Tile GetLandscape(Position position) {
        for (Tile tile : tiles) {
            if (tile.position.IsOverlap(position)) {
                return tile;
            }
        }

        return null;
    }

    public List<Enemy> GetUnits(Position position) {
        List<Enemy> overlaps = new ArrayList<Enemy>();
        for (Enemy enemy : units) {
            if (enemy.position.IsOverlap(position)) {
                overlaps.add(enemy);
            }
        }

        return overlaps;
    }

    public List<Player> GetPlayers(Position position) {
        List<Player> overlaps = new ArrayList<Player>();
        for (Player player : players) {
            if (player.position.IsOverlap(position)) {
                overlaps.add(player);
            }
        }

        return overlaps;
    }

    public boolean IsInsideZone(Position newPosition) {
        if (newPosition.X < map.X) return false;
        if (newPosition.Y < map.Y) return false;
        if (newPosition.X + newPosition.Width > map.X + map.Width) return false;
        return newPosition.Y + newPosition.Height <= map.Y + map.Height;
    }

    @Override
    public void ProcessInput(GameController controller) {
        for (Tile tile : tiles) {
            tile.ProcessInput(controller);
        }

        for (Player player : players) {
            player.ProcessInput(controller);
        }

        for (Enemy enemy : units) {
            enemy.ProcessInput(controller);
        }
    }

    @Override
    public void Update(World world) {
        for (Tile tile : tiles) {
            tile.Update(world);
        }

        for (Player player : players) {
            player.Update(world);
        }

        removeIsDead(units);
        for (Enemy enemy : units) {
            enemy.Update(world);
        }
    }

    @Override
    public void Repaint(GameGraphics g2d) {
        for (Tile tile: tiles) {
            tile.Repaint(g2d);
        }

        for (Player player: players) {
            player.Repaint(g2d);
        }

        for (Enemy enemy: units) {
            enemy.Repaint(g2d);
        }
    }

    private void removeIsDead(List<Enemy> list){
        for(Iterator<Enemy> iterator = list.iterator(); iterator.hasNext(); ) {
            if(iterator.next().isDead){
                iterator.remove();
            }
        }
    }
}
