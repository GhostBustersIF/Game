package com.ghostbusters.game.GameObjects;

import com.ghostbusters.framework.Pixmap;
import com.ghostbusters.game.Actions.GameAction;
import com.ghostbusters.game.Actions.PlayerMoveAction;
import com.ghostbusters.game.Assets;
import com.ghostbusters.game.Configs.PlayerConfig;
import com.ghostbusters.game.GameController;
import com.ghostbusters.game.GameGraphics;
import com.ghostbusters.game.Structures.Direction;
import com.ghostbusters.game.Structures.Position;
import com.ghostbusters.game.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Player implements GameObject {
    private final int ANIM_DELAY = 20;
    private final int ANIM_COUNT = 3;
    private final Map<Direction, List<Pixmap>> animation;

    public Position position = new Position(100, 100, 12, 12);
    public Direction direction;
    public int velocity = 30;
    public boolean isDead = true;

    private int AnimCount = ANIM_DELAY;//лічильник зміни анімації
    private int AnimPos = 1;
    private boolean changeAnimation = true;
    private List<GameAction> actions = new ArrayList<>();

    public Player(Map<Direction, List<Pixmap>> animation) {
        this.animation = animation;
    }

    public Player(PlayerConfig config) {
        this.position=config.position;
        this.direction=config.startDirection;
        this.velocity=config.velocity;
        this.animation=config.animation;
    }

    @Override
    public void ProcessInput(GameController controller) {
        this.actions.clear();
        if (controller.Left) {
            this.actions.add(new PlayerMoveAction(this, Direction.Left));
        }

        if (controller.Right) {
            this.actions.add(new PlayerMoveAction(this, Direction.Right));
        }

        if (controller.Up) {
            this.actions.add(new PlayerMoveAction(this, Direction.Up));
        }

        if (controller.Down) {
            this.actions.add(new PlayerMoveAction(this, Direction.Down));
        }
    }

    @Override
    public void Update(World world) {
        world.processActions(this.actions);

        if (this.isDead)
        {
            world.GameOver();
        }
    }

    @Override
    public void Repaint(GameGraphics ui) {
        doAnim();
        drawDirection(ui,direction);
    }

    private void drawDirection(GameGraphics ui, Direction direction) {
        List<Pixmap> list = this.animation.get(direction);
        if(list != null){
        DrawAnim(ui, list.get(0), list.get(1), list.get(2));}
//        DrawAnim(ui, Assets.up1, Assets.up2, Assets.up3);
    }

    private void DrawAnim(GameGraphics ui, Pixmap image1, Pixmap image2, Pixmap image3) {
        switch (AnimPos) {
            case 1:
                ui.drawImage(image1, this.position.X + 1, this.position.Y + 1);
                break;
            case 2:
                ui.drawImage(image2, this.position.X + 1, this.position.Y + 1);
                break;
            case 3:
                ui.drawImage(image3, this.position.X + 1, this.position.Y + 1);
                break;
            default:
                ui.drawImage(image2, this.position.X + 1, this.position.Y + 1);
                break;
        }
    }

    private void doAnim() {
        if(!actions.isEmpty()) {
            AnimCount--;
        }
        if (AnimCount <= 0) {
            AnimCount = ANIM_DELAY;
            if(changeAnimation){
                AnimPos++;
                if(AnimPos >= ANIM_COUNT)
                    changeAnimation = false;
                }
            else {
                AnimPos--;
                if(AnimPos <= 1)
                    changeAnimation = true;
                }
        }
    }
}
