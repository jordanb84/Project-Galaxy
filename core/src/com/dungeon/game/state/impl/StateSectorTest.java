package com.dungeon.game.state.impl;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dungeon.game.map.Map;
import com.dungeon.game.map.sector.impl.SectorPaso;
import com.dungeon.game.state.State;
import com.dungeon.game.state.StateController;

public class StateSectorTest extends State {

    private Map map;

    public StateSectorTest(StateController stateController) {
        super(stateController);
        this.map = new Map(new SectorPaso(this.map));
    }

    @Override
    public void render(SpriteBatch batch, OrthographicCamera camera) {
        this.map.render(batch, camera);
    }

    @Override
    public void update(OrthographicCamera camera) {
        this.map.update(camera);
    }
}
