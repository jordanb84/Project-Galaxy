package com.dungeon.game.entity.ship.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entity.ship.Ship;
import com.dungeon.game.map.Map;

public class ShipTest extends Ship {

    public ShipTest(Map parentMap, Vector2 position) {
        super(parentMap,"ships/paso_merchant_class.png", 2, 0.3f, 50);
        this.setRotation(20);
        this.getPosition().set(position);
    }

    @Override
    public void update(OrthographicCamera camera) {

    }
}
