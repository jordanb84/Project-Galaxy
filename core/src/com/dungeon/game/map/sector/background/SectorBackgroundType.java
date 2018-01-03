package com.dungeon.game.map.sector.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public enum SectorBackgroundType {

    Paso("background/paso.png");

    SectorBackgroundType(String spritePath) {
        this.SPRITE = new Sprite(new Texture(Gdx.files.internal(spritePath)));
    }

    public final Sprite SPRITE;

}
