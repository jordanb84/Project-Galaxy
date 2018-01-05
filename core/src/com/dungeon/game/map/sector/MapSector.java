package com.dungeon.game.map.sector;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.Game;
import com.dungeon.game.entity.Entity;
import com.dungeon.game.map.Map;
import com.dungeon.game.map.sector.background.SectorBackground;
import com.dungeon.game.map.sector.background.SectorBackgroundType;
import com.dungeon.game.map.sector.planet.Planet;

import java.util.ArrayList;
import java.util.List;

public abstract class MapSector {

    private Map map;

    private SectorBackground background;

    private List<Entity> entities = new ArrayList<Entity>();

    private List<Entity> entitySpawnQueue = new ArrayList<Entity>();
    private List<Entity> entityDespawnQueue = new ArrayList<Entity>();

    private Planet planet;

    public MapSector(Map map, Planet planet, SectorBackground background) {
        this.map = map;
        this.background = background;
        this.planet = planet;
    }

    public void render(SpriteBatch batch, OrthographicCamera camera) {
        batch.end();
        this.background.render();
        batch.begin();

        this.planet.render(batch, camera);

        for(Entity entity : this.entities) {
            entity.render(batch, camera);
        }
    }

    public void update(OrthographicCamera camera) {
        for(Entity entity : this.entitySpawnQueue) {
            this.entities.add(entity);
        }

        this.entitySpawnQueue.clear();

        for(Entity entity : this.entityDespawnQueue) {
            this.entities.remove(entity);
        }

        this.entityDespawnQueue.clear();

        for(Entity entity : this.entities) {
            entity.update(camera);
        }

        this.planet.update(camera);
    }

    public SectorBackground getBackground() {
        return this.background;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return this.map;
    }

    public void spawnEntity(Entity entity) {
        this.entitySpawnQueue.add(entity);
    }

    public void despawnEntity(Entity entity) {
        this.entityDespawnQueue.add(entity);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public Planet getPlanet() {
        return planet;
    }
}
