package com.ky1emart.area51.handlers.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.ky1emart.area51.entities.SpriteActor;
import com.ky1emart.area51.handlers.movement.MovementHandler;

import java.util.Random;

/**
 * Created by Kyle Martinez on 2/24/15.
 */
public class RandomMovement implements MovementHandler {

    private int travelTime;

    private Vector2 destination = new Vector2();

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public Vector2 createRandomScreenPoint(int xOffset, int yOffset) {
        Random randomGenerator = new Random();
        Vector2 vector2 = new Vector2();
        vector2.x = randomGenerator.nextInt(Gdx.graphics.getWidth() - xOffset);
        vector2.y = randomGenerator.nextInt(Gdx.graphics.getHeight() - yOffset);
        return vector2;
    }

    public boolean isAtDestination(SpriteActor sprite) {
        return MathUtils.floor(destination.x - sprite.getX()) == 0
                && MathUtils.floor(destination.y - sprite.getY()) == 0;
    }

    @Override
    public void update(SpriteActor sprite, float deltaTime) {
        if (isAtDestination(sprite)) {
            destination = createRandomScreenPoint((int) sprite.getWidth(), (int) sprite.getHeight());
            sprite.addAction(Actions.moveTo(destination.x, destination.y, travelTime));
        }

        sprite.act(deltaTime);
    }
}
