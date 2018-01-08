package com.dungeon.game.ui.impl;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.dungeon.game.Game;
import com.dungeon.game.entity.ship.impl.ShipPlayer;
import com.dungeon.game.state.StateController;
import com.dungeon.game.ui.SkinType;
import com.dungeon.game.ui.UiContainer;

public class GameHudContainer extends UiContainer {

    private ShipPlayer player;

    public GameHudContainer(StateController stateController, ShipPlayer player) {
        super(stateController, SkinType.Sgx);
        this.player = player;
    }

    @Override
    public void create() {
        HudControlWindow controlWindow = new HudControlWindow();
        this.getRootTable().add(controlWindow).width(250).height(200).padTop(Game.DISPLAY_HEIGHT - 250).padLeft(Game.DISPLAY_WIDTH / 2);
    }
}

class HudControlWindow extends Window {

    public HudControlWindow() {
        super("Ship Status", SkinType.Sgx.SKIN);
        Label shields = new Label("Shields", this.getSkin());

        this.add(shields).row();

        Slider shieldsSlider = new Slider(0, 10, 0.1f, false, this.getSkin());
        shieldsSlider.setValue(6);
        shieldsSlider.setDisabled(true);

        this.add(shieldsSlider).row();

        Label hull = new Label("Hull", this.getSkin());

        this.add(hull).row();

        Slider hullSlider = new Slider(0, 10, 0.1f, false, this.getSkin());
        hullSlider.setValue(10);
        hullSlider.setDisabled(true);

        this.add(hullSlider).row();

        Label power = new Label("Energy", this.getSkin());

        this.add(power).row();

        Slider powerSlider = new Slider(0, 10, 0.1f, false, this.getSkin());
        powerSlider.setValue(2);
        powerSlider.setDisabled(true);

        this.add(powerSlider);
    }

}