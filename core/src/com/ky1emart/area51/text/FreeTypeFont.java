package com.ky1emart.area51.text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.ky1emart.area51.utils.Drawable;

public final class FreeTypeFont {

    private BitmapFont font;

    private static final FreeTypeFontGenerator.FreeTypeFontParameter DEFAULT_FONT_PARAM
            = new FreeTypeFontGenerator.FreeTypeFontParameter();

    public FreeTypeFont(FileHandle fontFile) {
        this(fontFile, DEFAULT_FONT_PARAM);
    }

    public FreeTypeFont(FileHandle fontFile, FreeTypeFontGenerator.FreeTypeFontParameter fontParameter) {
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(fontFile);
        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();
    }

    public void draw(SpriteBatch spriteBatch, CharSequence str, float x, float y) {
        spriteBatch.begin();
        font.draw(spriteBatch, str, x, y);
        spriteBatch.end();
    }

    public float getHeight(CharSequence str) {
        return font.getBounds(str).height;
    }

    public float getWidth(CharSequence str) {
        return font.getBounds(str).width;
    }
}
