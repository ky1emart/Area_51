package com.ky1emart.area51.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SpriteActor extends Actor {

    private Image image;

    private Texture texture;

    public SpriteActor(Texture texture) {
        this.texture = texture;
        image = new Image(texture);
    }

    public void translateY(float amount) {
        setY(getY() + amount);
    }

    public void translateX(float amount) {
        setX(getX() + amount);
    }

    @Override
    public float getHeight() {
        return image.getHeight();
    }

    @Override
    public float getWidth() {
        return image.getWidth();
    }

    @Override
    public final void draw(Batch batch, float alphaParent) {
        batch.begin();
        batch.draw(texture, getX(), getY());
        batch.end();
    }
}
