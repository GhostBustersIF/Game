package com.ghostbusters.game.GameObjects;

import com.ghostbusters.framework.Pixmap;
import com.ghostbusters.game.Actions.GameAction;
import com.ghostbusters.game.Actions.MoveAction;
import com.ghostbusters.game.Assets;
import com.ghostbusters.game.GameController;
import com.ghostbusters.game.GameGraphics;
import com.ghostbusters.game.Structures.Direction;
import com.ghostbusters.game.Structures.Position;
import com.ghostbusters.game.World;

import java.util.ArrayList;
import java.util.List;

public class Enemy implements GameObject {
    private final int ANIM_DELAY = 20;
    private final int ANIM_COUNT = 3;

    public Position position = new Position(200, 200, 12, 12);
    public Direction direction = Direction.randomDirection();
    public int velocity = 80;
    public boolean isDead;

    private int stepsInSameDirection = 0;
    private int maxStepsInSameDirection = 10;
    private int AnimCount = ANIM_DELAY;//лічильник зміни анімації
    private int AnimPos = 1;
    private boolean changeAnimation = true;
    private List<GameAction> actions = new ArrayList<>();

    @Override
    public void ProcessInput(GameController controller) {
        this.actions.clear();

        this.actions.add(new MoveAction(this, this.direction));
    }

    @Override
    public void Update(World world) {

            world.processActions(this.actions);

            if (stepsInSameDirection++ >= maxStepsInSameDirection) {
                this.direction = Direction.randomDirection();
                stepsInSameDirection = 0;
            }

    }

    @Override
    public void Repaint(GameGraphics ui) {
            doAnim();
            switch (direction) {
                case Left:
                    drawLeft(ui);
                    break;
                case Up:
                    drawUp(ui);
                    break;
                case Right:
                    drawRight(ui);
                    break;
                case Down:
                    drawDown(ui);
                    break;
                default:
                    drawRight(ui);
                    break;
            }

    }

    private void drawUp(GameGraphics ui) {

        DrawAnim(ui, Assets.enemy_up1, Assets.enemy_up2, Assets.enemy_up3);
    }

    private void drawDown(GameGraphics ui) {

        DrawAnim(ui, Assets.enemy_down1, Assets.enemy_down2, Assets.enemy_down3);
    }

    private void drawLeft(GameGraphics ui) {

        DrawAnim(ui, Assets.enemy_left1, Assets.enemy_left2, Assets.enemy_left3);
    }

    private void drawRight(GameGraphics ui) {

        DrawAnim(ui, Assets.enemy_right1, Assets.enemy_right2, Assets.enemy_right3);
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
