package com.dungeon.game.state.impl;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dungeon.game.map.Map;
import com.dungeon.game.map.sector.impl.SectorVesta;
import com.dungeon.game.state.State;
import com.dungeon.game.state.StateController;
import com.dungeon.game.ui.impl.GameHudContainer;

public class StateSectorTest extends State {

    private Map map;

    private GameHudContainer gameHud;

    public StateSectorTest(StateController stateController) {
        super(stateController);
        this.map = new Map(new SectorVesta(this.map));
        this.gameHud = new GameHudContainer(stateController, this.map.getPlayer());
    }

    @Override
    public void render(SpriteBatch batch, OrthographicCamera camera) {
        this.map.render(batch, camera);

        this.gameHud.render();
    }

    @Override
    public void update(OrthographicCamera camera) {
        this.map.update(camera);

        this.gameHud.update();
    }
}
