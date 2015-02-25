package com.ky1emart.area51.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.ky1emart.area51.game.Game;
import com.ky1emart.area51.states.State;
import com.ky1emart.area51.states.StateManager;
import com.ky1emart.area51.text.AnimatedText;
import com.ky1emart.area51.text.FreeTypeFont;
import com.ky1emart.area51.utils.Updatable;

/**
 * Created by Kyle Martinez on 2/24/15.
 */
public class GameOverState extends State implements Updatable, Renderable {

    private int score;

    private FreeTypeFont titleFont;

    private FreeTypeFont pressSpaceFont;

    private AnimatedText pressStartAnimation;

    public GameOverState(StateManager stateManager, int score) {
        super(stateManager);

        this.score = score;

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FileHandle fontFile = Gdx.files.internal("fonts/square_pixel.ttf");

        fontParameter.size = 30 * Game.SCALE;
        titleFont = new FreeTypeFont(fontFile, fontParameter);

        fontParameter.size = 20 * Game.SCALE;
        pressSpaceFont = new FreeTypeFont(fontFile, fontParameter);

        String pressStartText = "Press Space To Restart";
        pressStartAnimation = new AnimatedText(0.5f, pressStartText, String.format("> %s <", pressStartText));
    }

    private int counter;

    @Override
    public void render() {
        String titleText = "You Traveled " + ((counter <= score) ? counter++ : score) + " Units";
        titleFont.draw(spriteBatch, titleText,
                (Gdx.graphics.getWidth() - titleFont.getWidth(titleText)) / 2,
                (Gdx.graphics.getHeight() + titleFont.getHeight(titleText)) / 1.75f);

        pressSpaceFont.draw(spriteBatch, pressStartAnimation.toString(),
                (Gdx.graphics.getWidth() - pressSpaceFont.getWidth(pressStartAnimation.toString())) / 2,
                (Gdx.graphics.getHeight() + pressSpaceFont.getHeight(pressStartAnimation.toString())) / 3);
    }

    @Override
    public void update(float deltaTime) {
        pressStartAnimation.update(deltaTime);

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            stateManager.switchState(new MenuState(stateManager));
        }
    }
}
