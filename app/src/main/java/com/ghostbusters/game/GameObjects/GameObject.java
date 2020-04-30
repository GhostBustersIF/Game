package com.ghostbusters.game.GameObjects;

import com.ghostbusters.game.GameController;
import com.ghostbusters.game.GameGraphics;
import com.ghostbusters.game.World;

public interface GameObject {

    void ProcessInput(GameController controller);

    void Update(World world);

    void Repaint(GameGraphics g2d);
}
