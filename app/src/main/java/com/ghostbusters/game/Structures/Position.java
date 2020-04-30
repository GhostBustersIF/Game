package com.ghostbusters.game.Structures;

public class Position {
    public final int X; // top left corner
    public final int Y; // top left corner
    public final int Width;
    public final int Height;

    public Position(int x, int y, int width, int height)
    {
        this.X = x;
        this.Y = y;
        this.Width = width;
        this.Height = height;
    }

    public Position MoveTo(int x, int y)
    {
        return new Position(x, y, this.Width, this.Height);
    }

    public boolean IsOverlap(Position other)
    {
        if (other.X >= X + Width || X >= other.X + other.Width ) return false;
        return other.Y < Y + Height && Y < other.Y + other.Height;
    }
}
