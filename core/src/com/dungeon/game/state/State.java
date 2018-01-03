package com.dungeon.game.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {

    private StateController stateController;

    public State(StateController stateController) {
        this.stateController = stateController;
    }

    public abstract void render(SpriteBatch batch, OrthographicCamera camera);

    public abstract void update(OrthographicCamera camera);

    public StateController getStateController() {
        return stateController;
    }
}
