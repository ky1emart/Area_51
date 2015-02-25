package com.ky1emart.area51.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.ky1emart.area51.backgrounds.ParallaxBackground;
import com.ky1emart.area51.entities.Enemy;
import com.ky1emart.area51.entities.Missile;
import com.ky1emart.area51.entities.Player;
import com.ky1emart.area51.game.Game;
import com.ky1emart.area51.handlers.movement.PlayerMovement;
import com.ky1emart.area51.handlers.movement.StalkerMovement;
import com.ky1emart.area51.text.FreeTypeFont;
import com.ky1emart.area51.utils.Updatable;

public class PlayState extends State implements Updatable, Renderable {

    private static final String MUSIC_ID = "play_state";

    private Enemy jet;

    private Player ufo;

    private Missile missile;

    private ParallaxBackground background;

    private FreeTypeFont font;

    private int distanceTravled;

    private float timeAccumulator;

    public PlayState(StateManager stateManager) {
        super(stateManager);

        ufo = new Player(new PlayerMovement());
        ufo.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

        StalkerMovement stalkerMovement = new StalkerMovement();
        stalkerMovement.setEntityToStalk(ufo);
        stalkerMovement.setTravelTime(1);
        stalkerMovement.setStalkingDistance(45);
        jet = new Enemy(stalkerMovement);
        jet.setY(Gdx.graphics.getHeight());
        jet.setFiringDelay(5);

        missile = new Missile();
        missile.setPosition(1000, 1000); // temp fix
        missile.setSpeed(900);

        background = new ParallaxBackground(Game.res.getTexture("sky"));
        background.setVerticalVelocity(1500);

        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 20;
        font = new FreeTypeFont(Gdx.files.internal("fonts/square_pixel.ttf"), fontParameter);

        Game.res.getMusic(MUSIC_ID).play();
        Game.res.getMusic(MUSIC_ID).setLooping(true);
    }

    @Override
    public void render() {
        background.draw(spriteBatch);
        ufo.draw(spriteBatch);
        missile.draw(spriteBatch);
        jet.draw(spriteBatch);

        String distanceStr = "DISTANCE TRAVELED: " + distanceTravled;
        font.draw(spriteBatch, distanceStr, Game.SCALE, (Gdx.graphics.getHeight() - font.getHeight(distanceStr) / 2));
    }

    @Override
    public void update(float deltaTime) {
        timeAccumulator += deltaTime;
        if (timeAccumulator >= 1) {
            timeAccumulator = 0;
            distanceTravled++;
        }

        background.update(deltaTime);
        ufo.update(deltaTime);
        jet.update(deltaTime);
        if (jet.isReadyToAttack() && Math.random() >= 0.1) {
                missile.setPosition(jet.getX(), jet.getY());
                Game.res.getSound("missile").play();
        }
        missile.update(deltaTime);


        if (missile.getX() + missile.getWidth() >= ufo.getX()
                && missile.getX() + missile.getWidth() <= ufo.getX() + ufo.getWidth()
                && missile.getY() + (missile.getHeight() / 2) >= ufo.getY()
                && missile.getY() + (missile.getHeight() / 2) <= ufo.getY() + ufo.getHeight()) {
            Game.res.getMusic(MUSIC_ID).stop();
            Game.res.getSound("missile").stop();
            Game.res.getSound("explosion").play();
            stateManager.switchState(new GameOverState(stateManager, distanceTravled));
        }
    }
}
