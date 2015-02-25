package com.ky1emart.area51.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ky1emart.area51.utils.Drawable;
import com.ky1emart.area51.utils.Positionable;
import com.ky1emart.area51.utils.Updatable;

public abstract class BaseEntity implements Updatable, Drawable, Positionable {

    private static final float DEFAULT_ALPHA_PARENT = 1.0f;

    protected final SpriteActor spriteActor;

    public BaseEntity(Texture texture) {
        spriteActor = new SpriteActor(texture);
    }

    public float getHeight() {
        return spriteActor.getHeight();
    }

    public float getWidth() {
        return spriteActor.getWidth();
    }

    @Override
    public float getX() {
        return spriteActor.getX();
    }

    @Override
    public float getY() {
        return spriteActor.getY();
    }

    @Override
    public void setY(float y) {
        spriteActor.setY(y);
    }

    @Override
    public void setX(float x) {
        spriteActor.setX(x);
    }

    @Override
    public void setPosition(float x, float y) {
        spriteActor.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        spriteActor.draw(spriteBatch, DEFAULT_ALPHA_PARENT);
    }

    @Override
    abstract public void update(float deltaTime);
}
