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

import java.util.ArrayList;
import java.util.List;

public abstract class MapSector {

    private Map map;

    private SectorBackground background;

    private List<Entity> entities = new ArrayList<Entity>();

    private List<Entity> entitySpawnQueue = new ArrayList<Entity>();
    private List<Entity> entityDespawnQueue = new ArrayList<Entity>();

    private OrthographicCamera backgroundCamera;
    private SpriteBatch backgroundBatch;

    private Texture starsLayerOne;
    private Texture starsLayerTwo;

    public static float MOVE_ONE_X = 0;
    public static float MOVE_ONE_Y = 0;

    public MapSector(Map map, SectorBackground background) {
        this.map = map;
        this.background = background;

        this.backgroundCamera = new OrthographicCamera();
        this.backgroundCamera.setToOrtho(false, Game.DISPLAY_WIDTH, Game.DISPLAY_HEIGHT);

        this.backgroundBatch = new SpriteBatch();

        this.starsLayerOne = new Texture(Gdx.files.internal("background/stars1.png"));
        this.starsLayerTwo = new Texture(Gdx.files.internal("background/stars2.png"));

        this.starsLayerOne.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    }

    public void render(SpriteBatch batch, OrthographicCamera camera) {
        batch.end();
        this.background.render();

        /**this.backgroundBatch.setProjectionMatrix(this.backgroundCamera.combined);
        this.backgroundBatch.begin();
        this.backgroundBatch.draw(this.getBackground().SPRITE, 0, 0);

        Vector2 playerPosition = this.getMap().getPlayer().getPosition();

        this.backgroundBatch.draw(this.starsLayerOne, 0, 0, (int) this.MOVE_ONE_X, (int) this.MOVE_ONE_Y, 640, 480);
        //this.backgroundBatch.draw(this.starsLayerTwo, 10, 10, (int) playerPosition.x, (int) playerPosition.y, 640, 480);
        this.backgroundBatch.end();**/

        batch.begin();

        System.out.println(this.getMap() + "A");
        System.out.println(this.getMap().getPlayer() + " B");

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

}
