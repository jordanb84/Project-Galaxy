package com.dungeon.game.map.sector.planet;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.Game;
import com.dungeon.game.map.sector.planet.government.GovernmentType;

public class Planet {

    private int population;

    private String name;

    private GovernmentType government;

    private Sprite sprite;

    private Vector2 position;

    public Planet(String name, GovernmentType government, int population, Sprite sprite) {
        this.name = name;

        this.government = government;

        this.population = population;

        this.sprite = sprite;

        this.position = new Vector2(0, 0);

        this.sprite.setPosition(this.position.x, this.position.y);
    }

    public void render(SpriteBatch batch, OrthographicCamera camera) {
        this.sprite.draw(batch);
    }

    public void update(OrthographicCamera camera) {

    }

}
