package com.ghostbusters.game.GameObjects;

import android.graphics.Color;

import com.ghostbusters.framework.Game;
import com.ghostbusters.framework.Graphics;
import com.ghostbusters.framework.Input;

import java.util.List;

public class GameButton {

    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final int color;
    private boolean isPressed;

    public boolean isPressed() {
        return isPressed;
    }

    public GameButton(int x, int y, int width, int height, int color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    public void ProcessInput(List<Input.TouchEvent> input) {
        for (Input.TouchEvent touchEvent : input) {
            if (touchEvent.type == Input.TouchEvent.TOUCH_DOWN) {
                if(IsOnButton(touchEvent.x,touchEvent.y)){
                    this.isPressed = true;
                }
            }
            else {
                this.isPressed = false;
            }
        }
    }

    public void Update(Game game) {

    }

    public void Repaint(Graphics g2d) {
        g2d.drawRect(x,y,width,height, isPressed?color:Color.GREEN);
    }

    private boolean IsOnButton(int x, int y){
        if (x<=this.x + this.width && x>=this.x){
            if(y<=this.y + this.height && y>=this.y){
                return true;
            }
        }
        return false;
    }
}
