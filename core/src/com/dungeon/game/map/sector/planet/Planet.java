package com.dungeon.game.map.sector.planet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.dungeon.game.Game;
import com.dungeon.game.map.sector.planet.government.GovernmentType;

public class Planet {

    private int population;

    private String name;

    private GovernmentType government;

    private Sprite sprite;

    private Vector2 position;

    private Rectangle planetBody;

    public Planet(String name, GovernmentType government, int population, Sprite sprite) {
        this.name = name;

        this.government = government;

        this.population = population;

        this.sprite = sprite;

        this.position = new Vector2(0, 0);

        this.sprite.setPosition(this.position.x, this.position.y);

        this.planetBody = new Rectangle(this.position.x, this.position.y, this.sprite.getWidth(), this.sprite.getHeight());
    }

    public void render(SpriteBatch batch, OrthographicCamera camera) {
        this.sprite.draw(batch);
    }

    public void update(OrthographicCamera camera) {
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            System.out.println("Clicking. Planet: " + this.planetBody.getX() + "/" + this.planetBody.getY() + "/" + this.planetBody.getWidth() + "/" + this.planetBody.getHeight());
            Vector3 mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);

            camera.unproject(mousePosition);

            Rectangle mouseBody = new Rectangle(mousePosition.x, mousePosition.y, 1, 1);

            if(mouseBody.overlaps(this.planetBody)) {
                System.out.println("Overlaps");
            }
        }
    }

    public String getName() {
        return name;
    }
}
