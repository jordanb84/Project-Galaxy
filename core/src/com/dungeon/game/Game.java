package com.dungeon.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dungeon.game.entity.ship.impl.ShipPlayer;
import com.dungeon.game.state.StateController;
import com.dungeon.game.state.impl.StateSectorTest;
import com.dungeon.game.state.impl.StateStartMenu;

public class Game extends ApplicationAdapter {

	public static final int DISPLAY_WIDTH = 960;
	public static final int DISPLAY_HEIGHT = 720;

	private SpriteBatch batch;

	private OrthographicCamera camera;

	private StateController stateController;

	@Override
	public void create () {
		batch = new SpriteBatch();

		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		this.stateController = new StateController();

		this.stateController.registerState("newGame", new StateSectorTest(this.stateController));
		this.stateController.registerState("startMenu", new StateStartMenu(this.stateController));

		this.stateController.setActiveState("startMenu");
	}

	@Override
	public void render () {
		this.stateController.updateActiveState(this.camera);

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.batch.setProjectionMatrix(this.camera.combined);
		this.batch.begin();
		this.stateController.renderActiveState(this.batch, this.camera);
		this.batch.end();
	}
	
	@Override
	public void dispose () {
		this.batch.dispose();
	}
}
