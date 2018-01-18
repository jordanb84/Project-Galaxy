package com.dungeon.game.entity.mind;

import com.dungeon.game.entity.Entity;

public abstract class EntityState {

    private Mind parentMind;

    public EntityState(Mind parentMind) {
        this.parentMind = parentMind;
    }

    /**
     * Perform the function of the state
     */
    public abstract void perform();

    /**
     * Checks if the conditions have been met to transition to another state,
     * and switches to the new state if true
     */
    public abstract void checkTransitionConditions();

    public Mind getParentMind() {
        return parentMind;
    }

    public Entity getParentEntity() {
        return this.getParentMind().getParentEntity();
    }
}
