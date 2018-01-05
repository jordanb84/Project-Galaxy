package com.dungeon.game.map.sector.planet.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.dungeon.game.map.sector.planet.Planet;
import com.dungeon.game.map.sector.planet.government.GovernmentType;

public class PlanetVesta extends Planet {

    public PlanetVesta() {
        super("Vesta", GovernmentType.Vesta_Republic, 1495, new Sprite(new Texture(Gdx.files.internal("planet/planet_vesta.png"))));
    }

}
