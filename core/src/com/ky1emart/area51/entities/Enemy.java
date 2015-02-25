package com.ky1emart.area51.entities;

import com.ky1emart.area51.game.Game;
import com.ky1emart.area51.handlers.movement.MovementHandler;

/**
 * Created by Kyle Martinez on 2/24/15.
 */
public class Enemy extends BaseEntity {

    private MovementHandler movement;

    public void setFiringDelay(int firingDelay) {
        this.firingDelay = firingDelay;
    }

    private int firingDelay;

    private float timeAccumulator;

    public boolean isReadyToAttack() {
        return isReadyToAttack;
    }

    private boolean isReadyToAttack;

    public Enemy(MovementHandler movementHandler) {
        super(Game.res.getTexture("jet"));
        this.movement = movementHandler;
    }

    @Override
    public void update(float deltaTime) {
        movement.update(spriteActor, deltaTime);
        timeAccumulator += deltaTime;
        if (timeAccumulator >= firingDelay) {
            isReadyToAttack = true;
            timeAccumulator = 0;
        } else {
            isReadyToAttack = false;
        }
    }
}
