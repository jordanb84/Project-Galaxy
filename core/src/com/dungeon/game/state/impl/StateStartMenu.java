package com.dungeon.game.state.impl;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dungeon.game.state.State;
import com.dungeon.game.state.StateController;
import com.dungeon.game.ui.SkinType;
import com.dungeon.game.ui.impl.StartMenuContainer;

public class StateStartMenu extends State {

    private StartMenuContainer startMenu;

    public StateStartMenu(StateController stateController) {
        super(stateController);
        this.startMenu = new StartMenuContainer(stateController, SkinType.Sgx);
    }

    @Override
    public void render(SpriteBatch batch, OrthographicCamera camera) {
        this.startMenu.render();
    }

    @Override
    public void update(OrthographicCamera camera) {
        this.startMenu.update();
    }
}
