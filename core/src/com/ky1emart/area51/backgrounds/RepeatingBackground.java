package com.ky1emart.area51.backgrounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ky1emart.area51.utils.Drawable;

public class RepeatingBackground implements Drawable {

    /**
     *
     */
    protected final Texture texture;


    /**
     *
     */
    public RepeatingBackground(Texture texture) {
        this.texture = texture;
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(texture, 0, 0);
        spriteBatch.end();
    }
}
