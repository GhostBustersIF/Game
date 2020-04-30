package com.ghostbusters.game.GameObjects;

import com.ghostbusters.game.Assets;
import com.ghostbusters.game.GameController;
import com.ghostbusters.game.GameGraphics;
import com.ghostbusters.game.Structures.Position;
import com.ghostbusters.game.World;

public class Tile implements GameObject {
    public Position position = new Position(0, 0, 12, 12);

    public boolean IsWalkable() {
        return false;
    }

    @Override
    public void ProcessInput(GameController controller) {

    }

    @Override
    public void Update(World world) {

    }

    @Override
    public void Repaint(GameGraphics ui) {
        ui.drawImage(Assets.ghost, this.position.X , this.position.Y);
    }
}
