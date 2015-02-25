package com.ky1emart.area51.entities;

import com.badlogic.gdx.graphics.Texture;
import com.ky1emart.area51.game.Game;

/**
 * Created by Kyle Martinez on 2/24/15.
 */
public class Missile extends BaseEntity {

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private int speed;

    public Missile() {
        super(Game.res.getTexture("missile"));
    }

    @Override
    public void update(float deltaTime) {
        spriteActor.translateX(getSpeed() * deltaTime);
    }
}
