package com.ghostbusters.game.Structures;

public class Position {
    public final int X; // top left corner
    public final int Y; // top left corner
    public final int Width;
    public final int Height;
    public final float preciseX;
    public final float preciseY;

    public Position(int x, int y, int width, int height)
    {
        this.X = x;
        this.Y = y;
        this.Width = width;
        this.Height = height;
        this.preciseX = x;
        this.preciseY = y;
    }

    private Position(float preciseX, float preciseY, int width, int height){
        this.preciseX = preciseX;
        this.preciseY = preciseY;
        this.Width = width;
        this.Height = height;
        this.X = (int) preciseX;
        this.Y = (int) preciseY;
    }

    public Position MoveTo(float preciseX, float preciseY)
    {
        return new Position(preciseX, preciseY, this.Width, this.Height);
    }

    public boolean IsOverlap(Position other)
    {
        if (other.X >= X + Width || X >= other.X + other.Width ) return false;
        return other.Y < Y + Height && Y < other.Y + other.Height;
    }
}
