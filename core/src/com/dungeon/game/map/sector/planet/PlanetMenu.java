package com.dungeon.game.map.sector.planet;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.dungeon.game.ui.SkinType;
import com.dungeon.game.ui.UiContainer;

public class PlanetMenu extends UiContainer {

    private Planet planet;

    private Window mainWindow;

    public PlanetMenu(Planet planet) {
        super(null, SkinType.Sgx);
        //TODO Implement planet menu. It will display information about the planet and allow you to buy
        //basic resources for your ship (some sort of fuel?)
        this.planet = planet;

        this.mainWindow = new Window("Planet " + this.getPlanet().getName(), this.getSkin());

        this.mainWindow.setKeepWithinStage(true);
        this.mainWindow.setMovable(true);
        this.mainWindow.setResizable(false);
        this.mainWindow.setVisible(true);

        this.mainWindow.add(new TextButton("Hey!", this.getSkin()));

        this.getRootTable().add(this.mainWindow);
    }

    @Override
    public void create() {

    }

    public Planet getPlanet() {
        return planet;
    }
}
