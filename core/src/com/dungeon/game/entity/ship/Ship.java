package com.dungeon.game.entity.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entity.Entity;
import com.dungeon.game.map.Map;

public abstract class Ship extends Entity {

    private float speed;

    private float maximumSpeed;

    private float acceleration;

    private float maneuverability;

    private Map parentMap;

    public Ship(Map parentMap, String spritePath, float maximumSpeed, float acceleration, float maneuverability) {
        super(spritePath);
        this.maximumSpeed = maximumSpeed;
        this.acceleration = acceleration;
        this.maneuverability = maneuverability;
        this.parentMap = parentMap;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public float getMaximumSpeed() {
        return maximumSpeed;
    }

    public float getManeuverability() {
        return maneuverability;
    }

    public float getAcceleration() {
        return acceleration;
    }

    @Override
    public float getRotation() {
        return super.getRotation();
    }

    public Map getParentMap() {
        return parentMap;
    }
}
