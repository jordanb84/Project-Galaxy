package com.dungeon.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    private Vector2 position = new Vector2();

    private float rotation;

    private Sprite sprite;

    public Entity(String spritePath) {
        this.sprite = new Sprite(new Texture(Gdx.files.internal(spritePath)));
    }

    public abstract void update(OrthographicCamera camera);

    public void render(SpriteBatch batch, OrthographicCamera camera) {
        this.getSprite().setPosition(this.getPosition().x, this.getPosition().y);
        this.getSprite().setRotation(this.getRotation());
        this.getSprite().draw(batch);
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = (rotation);
    }


}
