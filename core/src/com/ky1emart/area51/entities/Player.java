package com.ky1emart.area51.entities;

import com.badlogic.gdx.Gdx;
import com.ky1emart.area51.handlers.movement.MovementHandler;
import com.ky1emart.area51.game.Game;

public final class Player extends BaseEntity {

    private MovementHandler movement;

    public Player(MovementHandler movementHandler) {
        super(Game.res.getTexture("ufo"));
        movement = movementHandler;
    }

    @Override
    public void update(float deltaTime) {
        float prevX = getX();
        float prevY = getY();
        movement.update(spriteActor, deltaTime);
        if (getY() + getHeight() > Gdx.graphics.getHeight() || getY() < 0) {
            setY(prevY);
        }
        if (getX() + getWidth() > Gdx.graphics.getWidth() || getX() < 0) {
            setX(prevX);
        }
    }
}
