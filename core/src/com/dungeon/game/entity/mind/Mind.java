package com.dungeon.game.entity.mind;

import com.dungeon.game.entity.Entity;
import com.dungeon.game.entity.ship.Ship;
import com.dungeon.game.state.State;

/**
 * The mind is the "brain" of an entity. It overlooks the entity's current state based on a finite state machine
 * system.
 */
public class Mind {

    private Ship parentEntity;

    private EntityState activeState;

    public Mind(Ship parentEntity, EntityState initialState) {
        this.parentEntity = parentEntity;
        this.activeState = initialState;
    }

    public void update() {
        this.activeState.perform();
        this.activeState.checkTransitionConditions();
    }

    public Ship getParentEntity() {
        return parentEntity;
    }

    public EntityState getActiveState() {
        return activeState;
    }
}
