package com.dungeon.game.entity.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entity.Direction;
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

    public void moveAtCurrentVelocity() {
        this.getPosition().add(-this.getSpeed() * (float) Math.cos(Math.toRadians(this.getRotation() - 90)), 0);
        this.getPosition().add(0, -this.getSpeed() * (float) Math.sin(Math.toRadians(this.getRotation() - 90)));
    }

    public void adjustMovementTo(Direction direction) {
        switch(direction) {
            case UP:
                this.setSpeed(this.getSpeed() + this.getAcceleration() * Gdx.graphics.getDeltaTime());

                if(this.getSpeed() >= this.getMaximumSpeed()) {
                    this.setSpeed(this.getMaximumSpeed());
                }
                break;
            case DOWN:
                this.setSpeed(this.getSpeed() - this.getAcceleration() * Gdx.graphics.getDeltaTime());

                if(this.getSpeed() <= 0) {
                    this.setSpeed(0);
                }
                break;
            case RIGHT:
                this.setRotation(this.getRotation() - this.getManeuverability() * Gdx.graphics.getDeltaTime());
                break;
            case LEFT:
                this.setRotation(this.getRotation() + this.getManeuverability() * Gdx.graphics.getDeltaTime());
                break;
        }
    }

    /**
     * Circles around the current position at maximum available speed
     */
    public void orbit() {
        this.adjustMovementTo(Direction.UP);
        this.adjustMovementTo(Direction.LEFT);
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
