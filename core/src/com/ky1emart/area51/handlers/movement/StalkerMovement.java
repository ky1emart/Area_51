package com.ky1emart.area51.handlers.movement;

import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.ky1emart.area51.entities.BaseEntity;
import com.ky1emart.area51.entities.SpriteActor;
import com.sun.istack.internal.NotNull;

/**
 * Created by Kyle Martinez on 2/24/15.
 */
public class StalkerMovement implements MovementHandler {

    private int travelTime;

    private int stalkingDistance;

    private BaseEntity entityToStalk;

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public void setStalkingDistance(int distance) {
        stalkingDistance = distance;
    }

    @NotNull
    public void setEntityToStalk(BaseEntity entity) {
        entityToStalk = entity;
    }

    @Override
    public void update(SpriteActor stalker, float deltaTime) {
        if (entityToStalk == null) {
            return;
        }

        float verticalOffset = stalker.getWidth() + stalkingDistance;
        stalker.addAction(Actions.moveTo(entityToStalk.getX() - verticalOffset, entityToStalk.getY(), travelTime));

        stalker.act(deltaTime);
    }
}
