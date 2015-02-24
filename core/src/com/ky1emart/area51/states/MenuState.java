package com.ky1emart.area51.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.ky1emart.area51.backgrounds.ParallaxBackground;
import com.ky1emart.area51.utils.Updatable;

/**
 * @author Kyle Martinez
 */
public class MenuState extends State implements Updatable, Renderable {

    private ParallaxBackground background;

    public MenuState(StateManager stateManager) {
        super(stateManager);

        final int BACKGROUND_VELOCITY = 20;
        background = new ParallaxBackground(new Texture(Gdx.files.internal("textures/space.png")));
        background.setVelocities(BACKGROUND_VELOCITY, BACKGROUND_VELOCITY);
    }

    @Override
    public void update(float deltaTime) {
        background.update(deltaTime);
    }

    @Override
    public void render() {
        background.draw(spriteBatch);
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
