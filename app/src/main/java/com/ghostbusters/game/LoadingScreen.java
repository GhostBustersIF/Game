package com.ghostbusters.game;

import com.ghostbusters.framework.Game;
import com.ghostbusters.framework.Graphics;
import com.ghostbusters.framework.Screen;
import com.ghostbusters.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.down1 = g.newPixmap("cats/yellow/down1.png", PixmapFormat.ARGB4444);
        Assets.down2 = g.newPixmap("cats/yellow/down2.png", PixmapFormat.ARGB4444);
        Assets.down3 = g.newPixmap("cats/yellow/down3.png", PixmapFormat.ARGB4444);
        Assets.enemy_down1 = g.newPixmap("mouse/white/down1.png", PixmapFormat.ARGB4444);
        Assets.enemy_down2 = g.newPixmap("mouse/white/down2.png", PixmapFormat.ARGB4444);
        Assets.enemy_down3 = g.newPixmap("mouse/white/down3.png", PixmapFormat.ARGB4444);
        Assets.ghost = g.newPixmap("mouse/white/down2.png", PixmapFormat.ARGB4444);
        Assets.left1 = g.newPixmap("cats/yellow/left1.png", PixmapFormat.ARGB4444);
        Assets.left2 = g.newPixmap("cats/yellow/left2.png", PixmapFormat.ARGB4444);
        Assets.left3 = g.newPixmap("cats/yellow/left3.png", PixmapFormat.ARGB4444);
        Assets.enemy_left1 = g.newPixmap("mouse/white/left1.png", PixmapFormat.ARGB4444);
        Assets.enemy_left2 = g.newPixmap("mouse/white/left2.png", PixmapFormat.ARGB4444);
        Assets.enemy_left3 = g.newPixmap("mouse/white/left3.png", PixmapFormat.ARGB4444);
        Assets.pacman = g.newPixmap("cats/yellow/down2.png", PixmapFormat.ARGB4444);//pacman текстура
        Assets.right1 = g.newPixmap("cats/yellow/right1.png", PixmapFormat.ARGB4444);
        Assets.right2 = g.newPixmap("cats/yellow/right2.png", PixmapFormat.ARGB4444);
        Assets.right3 = g.newPixmap("cats/yellow/right3.png", PixmapFormat.ARGB4444);
        Assets.enemy_right1 = g.newPixmap("mouse/white/right1.png", PixmapFormat.ARGB4444);
        Assets.enemy_right2 = g.newPixmap("mouse/white/right2.png", PixmapFormat.ARGB4444);
        Assets.enemy_right3 = g.newPixmap("mouse/white/right3.png", PixmapFormat.ARGB4444);
        Assets.up1 = g.newPixmap("cats/yellow/up1.png", PixmapFormat.ARGB4444);
        Assets.up2 = g.newPixmap("cats/yellow/up2.png", PixmapFormat.ARGB4444);
        Assets.up3 = g.newPixmap("cats/yellow/up3.png", PixmapFormat.ARGB4444);
        Assets.enemy_up1 = g.newPixmap("mouse/white/up1.png", PixmapFormat.ARGB4444);
        Assets.enemy_up2 = g.newPixmap("mouse/white/up2.png", PixmapFormat.ARGB4444);
        Assets.enemy_up3 = g.newPixmap("mouse/white/up3.png", PixmapFormat.ARGB4444);

//        Assets.click = game.getAudio().newSound("click.ogg");
//        Assets.eat = game.getAudio().newSound("eat.ogg");
//        Assets.bitten = game.getAudio().newSound("bitten.ogg");
//        Settings.load(game.getFileIO());
//        game.setScreen(new GameScreen(game));
        game.setScreen(new MenuScreen(game));
    }

    public void present(float deltaTime) {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
