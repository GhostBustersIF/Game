package com.ghostbusters.game.Loaders;

import com.ghostbusters.framework.Pixmap;
import com.ghostbusters.game.Structures.Direction;

import java.util.List;
import java.util.Map;

public interface LoadAnimationAsset {

    Map<Direction,List<Pixmap>> load (String path);

}

