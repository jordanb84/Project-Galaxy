package com.dungeon.game.entity.ship.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entity.Direction;
import com.dungeon.game.entity.Entity;
import com.dungeon.game.entity.mind.Mind;
import com.dungeon.game.entity.mind.impl.EntityStateWander;
import com.dungeon.game.entity.ship.Ship;
import com.dungeon.game.map.Map;

public class ShipTest extends Ship {

    public ShipTest(Map parentMap, Vector2 position) {
        super(parentMap,"ships/paso_merchant_class.png", 20, 0.3f, 50);
        this.setRotation(20);
        this.getPosition().set(position);
    }

    @Override
    public void render(SpriteBatch batch, OrthographicCamera camera) {
        super.render(batch, camera);
    }

    @Override
    public void update(OrthographicCamera camera) {
        this.actMind();

        //this.moveAtCurrentVelocity();
        //this.orbit();
    }

    @Override
    public Mind setupMind() {
        return new Mind(this, new EntityStateWander(this, new Vector2(500, 700)));
    }
}
