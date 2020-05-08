package com.ghostbusters.game.Configs;

import com.ghostbusters.framework.Pixmap;
import com.ghostbusters.game.Structures.Direction;
import com.ghostbusters.game.Structures.Position;

import java.util.List;
import java.util.Map;

public class EnemyConfig {
    public Position position;
    public Direction startDirection;
    public int velocity;
    public Map<Direction, List<Pixmap>> animation;
}
