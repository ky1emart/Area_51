package com.ky1emart.area51.states;

import com.ky1emart.area51.game.Game;
import com.ky1emart.area51.utils.Updatable;

import java.util.Stack;

/**
 * The states manager handles the
 */
public final class StateManager implements Updatable, Renderable {

    /**
     *
     */
    private Stack<State> states;

    /**
     *
     */
    private Game game;

    /**
     * Constructs a new <code>StateManager</code>.
     * @param game the game that will be rendering and updating this states manager
     */
    public StateManager(Game game) {
        this.game = game;
        states = new Stack<State>();
    }

    /**
     * Replaces the top-most states with a new states.
     * @param state the states to be added
     */
    public void switchState(State state) {
        popState();
        pushState(state);
    }

    /**
     *
     */
    public void popState() {
        states.pop().dispose();
    }

    /**
     *
     * @param state
     */
    public void pushState(State state) {
        states.push(state);
    }

    /**
     *
     * @return
     */
    public int size() {
        return states.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return states.isEmpty();
    }

    /**
     * If the current states is updatable, it will be updated with <code>deltaTime</code>.
     * @param deltaTime
     */
    @Override
    public void update(float deltaTime) {
        State state = states.peek();
        if (state instanceof Updatable) {
            ((Updatable) state).update(deltaTime);
        }
    }

    /**
     * If the current states is renderable, it will be rendered.
     */
    @Override
    public void render() {
        State state = states.peek();
        if (state instanceof Renderable) {
            ((Renderable) state).render();
        }
    }
}
