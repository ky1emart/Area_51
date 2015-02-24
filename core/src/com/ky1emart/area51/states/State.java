package com.ky1emart.area51.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

/**
 *
 */
public abstract class State implements Disposable {

    /**
     *
     */
    protected final StateManager stateManager;

    /**
     *
     */
    protected final SpriteBatch spriteBatch;

    /**
     *
     */
    public State(StateManager stateManager) {
        this.stateManager = stateManager;
        spriteBatch = new SpriteBatch();
    }

    abstract public void dispose();
}