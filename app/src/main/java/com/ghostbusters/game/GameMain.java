package com.ghostbusters.game;

import com.ghostbusters.framework.Screen;
import com.ghostbusters.framework.impl.AndroidGame;

public class GameMain extends AndroidGame {

    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
}
