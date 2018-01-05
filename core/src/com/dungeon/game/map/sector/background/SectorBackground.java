package com.dungeon.game.map.sector.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.Game;

import java.util.HashMap;
import java.util.Map;

public class SectorBackground {

    private OrthographicCamera camera;

    private SpriteBatch batch;

    private Sprite sprite;

    //hashmap of texture:position, when you call adjustStars(amount) it adjusts the first one by that amount,
    //the next by a little less, etc

    private HashMap<Texture, Vector2> starLayers = new HashMap<Texture, Vector2>();

    public SectorBackground(Sprite sprite) {
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, Game.DISPLAY_WIDTH, Game.DISPLAY_HEIGHT);

        this.batch = new SpriteBatch();

        this.sprite = sprite;

        this.addStarLayer("background/stars1.png");
        this.addStarLayer("background/stars2.png");
        this.addStarLayer("background/stars2.png");
    }

    public void render() {
        this.batch.setProjectionMatrix(this.camera.combined);
        this.batch.begin();
        this.sprite.setPosition(0, 0);
        this.sprite.draw(this.batch);

        for(Map.Entry<Texture, Vector2> starLayer : this.starLayers.entrySet()) {
            Texture starTexture = starLayer.getKey();

            Vector2 starPosition = starLayer.getValue();

            this.batch.draw(starTexture, 0, 0, (int) starPosition.x, (int) starPosition.y, Game.DISPLAY_WIDTH, Game.DISPLAY_HEIGHT);
        }

        this.batch.end();
    }

    public void adjustStars(Vector2 amount) {
        Vector2 currentAdjustAmount = new Vector2(amount.x, amount.y);

        Vector2 decrementAmount = new Vector2(currentAdjustAmount.x / 4, currentAdjustAmount.y / 4);

        for(Map.Entry<Texture, Vector2> starLayer : this.starLayers.entrySet()) {
            starLayer.getValue().add(currentAdjustAmount.x, currentAdjustAmount.y);

            currentAdjustAmount.add(-decrementAmount.x, -decrementAmount.y);
        }
    }

    private void addStarLayer(String path) {
        Texture starLayer = new Texture(Gdx.files.internal(path));

        starLayer.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        this.starLayers.put(starLayer, new Vector2());
    }

    public Sprite getSprite() {
        return this.sprite;
    }
}
