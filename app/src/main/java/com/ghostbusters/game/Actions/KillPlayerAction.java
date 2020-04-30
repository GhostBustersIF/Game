package com.ghostbusters.game.Actions;

import com.ghostbusters.game.GameObjects.Enemy;
import com.ghostbusters.game.GameObjects.Player;
import com.ghostbusters.game.World;

public class KillPlayerAction implements GameAction {
    private final Enemy killer;
    private final Player victim;

    public KillPlayerAction(Enemy killer, Player victim) {
        this.killer = killer;
        this.victim = victim;
    }

    @Override
    public void Execute(World world) {
        this.victim.isDead = true;
    }
}
