package com.dungeon.game.entity.ship.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entity.ship.Ship;
import com.dungeon.game.map.Map;
import com.dungeon.game.map.sector.MapSector;
import com.dungeon.game.map.sector.background.SectorBackground;

public class ShipPlayer extends Ship {

    public ShipPlayer(Map parentMap) {
        super(parentMap,"ships/paso_star_explorer_class.png", 10, 1f, 50);
        this.setRotation(30);
        this.getPosition().set(100, 100);
    }

    @Override
    public void update(OrthographicCamera camera) {
        float posX = (this.getPosition().x);
        float posY = (this.getPosition().y);

        float origX = (this.getPosition().x);
        float origY = (this.getPosition().y);

        float rotation = (this.getRotation());

        float forwardSpeed = this.getSpeed();
        float strafeSpeed = this.getSpeed();

        posX -= (this.getSpeed() * (float)Math.cos(Math.toRadians(rotation - 90)));
        posY -= (this.getSpeed() * (float)Math.sin(Math.toRadians(rotation - 90)));

        this.getPosition().set(posX, posY);

        camera.position.set(posX, posY, 0);
        camera.update();

        float diffX = (origX - posX);
        float diffY = (origY - posY);

        this.getParentMap().getActiveSector().getBackground().adjustStars(new Vector2(-diffX / 2, diffY / 2));

        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.setSpeed(this.getSpeed() + this.getAcceleration() * Gdx.graphics.getDeltaTime());

            if(this.getSpeed() >= this.getMaximumSpeed()) {
                this.setSpeed(this.getMaximumSpeed());
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.setSpeed(this.getSpeed() - (this.getAcceleration() * 2) * Gdx.graphics.getDeltaTime());

            if(this.getSpeed() <= 0) {
                this.setSpeed(0);
            }
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.setRotation(this.getRotation() - this.getManeuverability() * Gdx.graphics.getDeltaTime());
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.setRotation(this.getRotation() + this.getManeuverability() * Gdx.graphics.getDeltaTime());
        }
    }
}
