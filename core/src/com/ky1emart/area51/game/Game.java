package com.ky1emart.area51.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.ky1emart.area51.states.MenuState;
import com.ky1emart.area51.states.StateManager;

public class Game extends ApplicationAdapter {

    /**
     * The name of the application.
     */
    public static final String TITLE = "Area 51";

    /**
     * The factor by which the virtual width and height of the application are to be scaled by.
     */
    public static final int SCALE = 2;

    /**
     * The virtual height of the application window in pixels. Note that this value may not be accurate. It is
     * recommended that you use <code>Gdx.graphics.getHeight()</code>.
     */
    public static final int V_HEIGHT = 320 * SCALE;

    /**
     * The virtual width of the application screen in pixels. Note that this value may not be accurate. It is
     * recommended that you use <code>Gdx.graphics.getWidth()</code>.
     */
    public static final int V_WIDTH = 480 * SCALE;

    /**
     * The states manager manages the states by controlling what will be rendered and updated at any given time.
     */
    private StateManager stateManager;

	@Override
	public void create() {
        stateManager = new StateManager(this);
        stateManager.pushState(new MenuState(stateManager));
	}

	@Override
	public void render() {
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT); // clears screen color buffer

        stateManager.update(Gdx.graphics.getDeltaTime());
        stateManager.render();
	}

}
