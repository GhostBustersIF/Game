package com.ghostbusters.game;

import com.ghostbusters.framework.Game;
import com.ghostbusters.framework.Pixmap;

public class GameGraphics {
    private Game game;

    public GameGraphics(Game game)
    {
        this.game = game;
    }

    public void drawImage(Pixmap pixmap, int x, int y)
    {
        game.getGraphics().drawPixmap(pixmap, x, y);
    }
}
