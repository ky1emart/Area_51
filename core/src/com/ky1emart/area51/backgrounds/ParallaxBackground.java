package com.ky1emart.area51.backgrounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.ky1emart.area51.utils.Updatable;

/**
 *
 */
public class ParallaxBackground extends RepeatingBackground implements Updatable {

    /**
     *
     */
    private Vector2 velocity;

    /**
     *
     */
    private Vector2 location;

    /**
     *
     * @param texture
     */
    public ParallaxBackground(Texture texture) {
        super(texture);
        velocity = new Vector2();
        location = new Vector2();
    }

    /**
     *
     * @param verticalVelocity
     */
    public void setVerticalVelocity(int verticalVelocity) {
        this.velocity.x = verticalVelocity;
    }

    /**
     *
     * @param horizontalVelocity
     */
    public void setHorizontalVelocity(int horizontalVelocity) {
        this.velocity.y = horizontalVelocity;
    }

    /**
     *
     * @param verticalVelocity
     * @param horizontalVelocity
     */
    public void setVelocities(int verticalVelocity, int horizontalVelocity) {
        setVerticalVelocity(verticalVelocity);
        setHorizontalVelocity(horizontalVelocity);
    }

    /**
     *
     * @param deltaTime
     */
    @Override
    public void update(float deltaTime) {
        location.x += deltaTime * velocity.x;
        location.y += deltaTime * velocity.y;
    }

    /**
     *
     */
    @Override
    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(texture, 0, 0, (int) location.x, (int) location.y, Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        spriteBatch.end();
    }
}
