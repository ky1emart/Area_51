package com.ky1emart.area51.handlers.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.ky1emart.area51.entities.SpriteActor;

/**
 * Created by Kyle Martinez on 2/24/15.
 */
public class PlayerMovement implements MovementHandler {

    private static final int MOVEMENT_SPEED = 300;

    private static final int OSCILLATION_AMPLITUDE = 20;

    private static final int OSCILLATION_SPEED = 10;

    private float frameCounter;

    private void updateFrameCounter() {
        ++frameCounter;
    }

    private void updateOscillation(SpriteActor sprite, float deltaTime) {
        updateFrameCounter();
        float angleRad = MathUtils.degRad * frameCounter * OSCILLATION_SPEED;
        float deltaHeight = MathUtils.sin(angleRad) * OSCILLATION_AMPLITUDE * deltaTime;
        sprite.translateY(deltaHeight);
    }

    @Override
    public void update(SpriteActor sprite, float deltaTime) {
        float distance = MOVEMENT_SPEED * deltaTime;

        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP))
            sprite.setY(sprite.getY() + distance);
        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN))
            sprite.setY(sprite.getY() - distance);
        else
            updateOscillation(sprite, deltaTime);

        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
            sprite.setX(sprite.getX() + distance);
        else if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
            sprite.setX(sprite.getX() - distance);
    }
}
