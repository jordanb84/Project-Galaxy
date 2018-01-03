package com.dungeon.game.state;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class StateController {

    private String activeStateKey;

    private HashMap<String, State> registeredStates = new HashMap<String, State>();

    public StateController() {

    }

    public void renderActiveState(SpriteBatch batch, OrthographicCamera camera) {
        this.getActiveState().render(batch, camera);
    }

    public void updateActiveState(OrthographicCamera camera) {
        this.getActiveState().update(camera);
    }

    public void registerState(String name, State state) {
        this.registeredStates.put(name, state);
    }

    public void setActiveState(String name) {
        this.activeStateKey = name;
    }

    public State getActiveState() {
        return this.registeredStates.get(this.activeStateKey);
    }

}
