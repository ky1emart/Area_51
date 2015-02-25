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
    private float timeAccumulator;

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

    private void updateIndex() {
        ++index;
        index %= frames.length;
    }

    @Override
    public void update(float deltaTime) {
        timeAccumulator += deltaTime;
        if (timeAccumulator >= stateTime) {
            updateIndex();
            timeAccumulator = 0;
        }
    }

    @Override
    public String toString() {
        return frames[index].toString();
    }
}
