package com.dungeon.game.ui.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.dungeon.game.state.State;
import com.dungeon.game.state.StateController;
import com.dungeon.game.ui.SkinType;
import com.dungeon.game.ui.UiContainer;

public class StartMenuContainer extends UiContainer {

    private Image background;

    public StartMenuContainer(StateController stateController, SkinType skinType) {
        super(stateController, skinType);
    }

    @Override
    public void create() {
        this.getRootTable().setBackground(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("ui/menu/redplanet.png")))));

        this.getRootTable().add(new Label("Project Galaxy", this.getSkin())).center().pad(20);
        this.getRootTable().row();
        this.getRootTable().add(new NewGameButton(this.getStateController(), this.getSkin())).center().width(200);
        this.getRootTable().row().pad(20);
        this.getRootTable().add(new TextButton("Load Game", this.getSkin())).center().width(200);
        this.getRootTable().row();
        this.getRootTable().add(new TextButton("Settings", this.getSkin())).center().width(200);
    }
}

class NewGameButton extends TextButton {

    public NewGameButton(StateController stateController, Skin skin) {
        super("New Game", skin);

        this.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent clickEvent, float clickX, float clickY) {
               stateController.setActiveState("newGame");
           }
        });
    }

}