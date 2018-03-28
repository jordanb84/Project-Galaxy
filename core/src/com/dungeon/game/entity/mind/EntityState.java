package com.dungeon.game.entity.mind;

import com.dungeon.game.entity.Entity;
import com.dungeon.game.entity.ship.Ship;

public abstract class EntityState {

    private Ship parentShip;

    public EntityState(Ship parentShip) {
        this.parentShip = parentShip;
    }

    /**
     * Perform the function of the state
     */
    public abstract void perform();

    /**
     * Checks if the conditions have been met to transition to another state,
     * and switches to the new state if true aura
     */
    public abstract void checkTransitionConditions();

    public Mind getParentMind() {
        return this.getParentShip().getMind();
    }

    public Ship getParentShip() {
        return this.parentShip;
    }
}
