package com.dungeon.game.entity.ship.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entity.Direction;
import com.dungeon.game.entity.mind.Mind;
import com.dungeon.game.entity.ship.Ship;
import com.dungeon.game.map.Map;
import com.dungeon.game.map.sector.MapSector;
import com.dungeon.game.map.sector.background.SectorBackground;

public class ShipPlayer extends Ship {

    public ShipPlayer(Map parentMap) {
        super(parentMap,"ships/paso_star_explorer_class.png", 5, 1f, 50);
        this.setRotation(30);
        this.getPosition().set(100, 100);
    }

    @Override
    public Mind setupMind() {
        return null;
    }

    @Override
    public void update(OrthographicCamera camera) {
        float originalX = (this.getPosition().x);
        float originalY = (this.getPosition().y);

        this.moveAtCurrentVelocity();

        camera.position.set(this.getPosition().x, this.getPosition().y, 0);
        camera.update();

        float diffX = (originalX - this.getPosition().x);
        float diffY = (originalY - this.getPosition().y);

        this.getParentMap().getActiveSector().getBackground().adjustStars(new Vector2(-diffX / 2, diffY / 2));

        if(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.adjustMovementTo(Direction.UP);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.adjustMovementTo(Direction.DOWN);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.adjustMovementTo(Direction.RIGHT);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.adjustMovementTo(Direction.LEFT);
        }
    }
}
