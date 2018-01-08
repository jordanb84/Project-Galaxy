package com.dungeon.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.dungeon.game.state.StateController;

public abstract class UiContainer {

    private Stage stage;

    private Table rootTable;

    private Skin skin;

    private StateController stateController;

    public UiContainer(StateController stateController, SkinType skinType) {
        this.stateController = stateController;

        this.skin = skinType.SKIN;

        this.rootTable = new Table(this.getSkin());

        this.rootTable.setFillParent(true);

        this.stage = new Stage();

        this.stage.addActor(this.rootTable);

        Gdx.input.setInputProcessor(this.stage);

        this.create();
    }

    public abstract void create();

    public void render() {
        this.stage.draw();
    }

    public void update() {
        this.stage.act(Gdx.graphics.getDeltaTime());
    }

    public void setVisible(boolean visible) {
        this.getRootTable().setVisible(visible);
    }

    public boolean isVisible() {
        return this.getRootTable().isVisible();
    }

    public Skin getSkin() {
        return skin;
    }

    public Table getRootTable() {
        return rootTable;
    }

    public StateController getStateController() {
        return stateController;
    }
}
