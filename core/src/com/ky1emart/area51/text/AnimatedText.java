package com.ky1emart.area51.text;

import com.ky1emart.area51.utils.Updatable;

/**
 *
 */
public final class AnimatedText implements Updatable {

    /**
     *
     */
    private CharSequence[] frames;

    /**
     *
     */
    private int index;

    /**
     *
     */
    private float stateTime;

    /**
     *
     * @param stateTime
     * @param frames
     */
    public AnimatedText(float stateTime, CharSequence... frames) {
        this.stateTime = stateTime;
        this.frames = frames;
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public String toString() {
        return frames[index].toString();
    }
}
