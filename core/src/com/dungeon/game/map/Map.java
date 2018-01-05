package com.dungeon.game.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.dungeon.game.entity.ship.impl.ShipPlayer;
import com.dungeon.game.entity.ship.impl.ShipTest;
import com.dungeon.game.map.sector.MapSector;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private ShipPlayer player;

    private MapSector activeSector;

    private List<MapSector> sectors = new ArrayList<MapSector>();

    /** TODO Change to sector type enum or something. For the future it won't make any sense to register _one_ of the sectors outside and the others in here! And what if I want them to be different? **/
    public Map(MapSector initialSector) {
        initialSector.setMap(this);

        this.sectors.add(initialSector);

        this.activeSector = initialSector;

        this.player = new ShipPlayer(this);

        this.getActiveSector().spawnEntity(this.getPlayer());
        this.getActiveSector().spawnEntity(new ShipTest(this, new Vector2(180, 250)));
    }

    public void render(SpriteBatch batch, OrthographicCamera camera) {
        this.getActiveSector().render(batch, camera);
    }

    public void update(OrthographicCamera camera) {
        this.getActiveSector().update(camera);
    }

    public void moveToSector(MapSector currentSector, MapSector destinationSector) {
        this.activeSector = (destinationSector);
        //TODO Calculate power usage to move between the two sectors if the first is not null
    }

    public MapSector getActiveSector() {
        return activeSector;
    }

    public ShipPlayer getPlayer() {
        return this.player;
    }

}
