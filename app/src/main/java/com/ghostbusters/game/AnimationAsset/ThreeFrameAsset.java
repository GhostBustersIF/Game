package com.ghostbusters.game.AnimationAsset;

import android.util.ArrayMap;

import com.ghostbusters.framework.Graphics;
import com.ghostbusters.framework.Pixmap;
import com.ghostbusters.game.Loaders.LoadAnimationAsset;
import com.ghostbusters.game.Structures.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ThreeFrameAsset implements LoadAnimationAsset {
    private Graphics graphics;

    public ThreeFrameAsset(Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public Map<Direction, List<Pixmap>> load(String path) {
        Map<Direction, List<Pixmap>> frames = new ArrayMap<>();
        frames.put(Direction.Down,LoadFrames(path,"down"));
        frames.put(Direction.Up,LoadFrames(path,"up"));
        frames.put(Direction.Right,LoadFrames(path,"right"));
        frames.put(Direction.Left,LoadFrames(path,"left"));
        return frames;
    }

    private List<Pixmap> LoadFrames(String path, String pattern){
        List<Pixmap> list = new ArrayList<>();
        list.add(LoadFrame(path,pattern + "1.png"));
        list.add(LoadFrame(path,pattern + "2.png"));
        list.add(LoadFrame(path,pattern + "3.png"));
       return list;
    }

    private Pixmap LoadFrame (String path, String name){
        return graphics.newPixmap(path + name,  Graphics.PixmapFormat.ARGB4444);
    }
}
