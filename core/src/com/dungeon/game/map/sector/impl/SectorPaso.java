package com.dungeon.game.map.sector.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.dungeon.game.entity.Entity;
import com.dungeon.game.map.Map;
import com.dungeon.game.map.sector.MapSector;
import com.dungeon.game.map.sector.background.SectorBackground;
import com.dungeon.game.map.sector.background.SectorBackgroundType;

import java.util.ArrayList;
import java.util.List;

public class SectorPaso extends MapSector {

    public SectorPaso(Map map) {
        super(map, new SectorBackground(new Sprite(new Texture(Gdx.files.internal("background/paso.png")))));
    }

}
