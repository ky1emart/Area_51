package com.ky1emart.area51.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.ky1emart.area51.backgrounds.ParallaxBackground;
import com.ky1emart.area51.entities.Player;
import com.ky1emart.area51.game.Game;
import com.ky1emart.area51.handlers.movement.RandomMovement;
import com.ky1emart.area51.text.AnimatedText;
import com.ky1emart.area51.text.FreeTypeFont;
import com.ky1emart.area51.utils.Updatable;

/**
 * @author Kyle Martinez
 */
public class MenuState extends State implements Updatable, Renderable {

    private static final String MUSIC_ID = "main_state";

    private ParallaxBackground background;

    private FreeTypeFont titleFont;

    private FreeTypeFont pressSpaceFont;

    private AnimatedText pressStartAnimation;

    private Player ufo;

    public MenuState(StateManager stateManager) {
        super(stateManager);

        final int BACKGROUND_VELOCITY = 10;
        background = new ParallaxBackground(Game.res.getTexture("space"));
        background.setVelocities(BACKGROUND_VELOCITY, BACKGROUND_VELOCITY);

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        FileHandle fontFile = Gdx.files.internal("fonts/square_pixel.ttf");

        fontParameter.size = 90 * Game.SCALE;
        titleFont = new FreeTypeFont(fontFile, fontParameter);

        fontParameter.size = 30 * Game.SCALE;
        pressSpaceFont = new FreeTypeFont(fontFile, fontParameter);

        String pressStartText = "Press Space";
        pressStartAnimation = new AnimatedText(0.5f, pressStartText, String.format("> %s <", pressStartText));

        RandomMovement randomMovement = new RandomMovement();
        randomMovement.setTravelTime(1);
        ufo = new Player(randomMovement);

        Game.res.getMusic(MUSIC_ID).setLooping(true);
        Game.res.getMusic(MUSIC_ID).play();
    }

    @Override
    public void update(float deltaTime) {
        background.update(deltaTime);

        pressStartAnimation.update(deltaTime);

        ufo.update(deltaTime);

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            Game.res.getSound("selection").play();
            Game.res.getMusic(MUSIC_ID).stop();

            stateManager.switchState(new PlayState(stateManager));
        }
    }

    @Override
    public void render() {
        background.draw(spriteBatch);

        ufo.draw(spriteBatch);

        titleFont.draw(spriteBatch, Game.TITLE,
                (Gdx.graphics.getWidth() - titleFont.getWidth(Game.TITLE)) / 2,
                (Gdx.graphics.getHeight() + titleFont.getHeight(Game.TITLE)) / 1.75f);

        pressSpaceFont.draw(spriteBatch, pressStartAnimation.toString(),
                (Gdx.graphics.getWidth() - pressSpaceFont.getWidth(pressStartAnimation.toString())) / 2,
                (Gdx.graphics.getHeight() + pressSpaceFont.getHeight(pressStartAnimation.toString())) / 3);
    }
}
