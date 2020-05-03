package com.ghostbusters.game;

import com.ghostbusters.framework.Graphics;
import com.ghostbusters.framework.Pixmap;

public class GameGraphics {
    private Graphics graphics;

    public GameGraphics(Graphics graphics)
    {
        this.graphics = graphics;
    }

    public void drawImage(Pixmap pixmap, int x, int y)
    {
        graphics.drawPixmap(pixmap, x, y);
    }
}
