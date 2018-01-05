package com.dungeon.game.map.sector.planet.government;

public enum GovernmentType {
    Vesta_Republic("Republic of Vesta")
    ;

    GovernmentType(String name) {
        this.NAME = name;
    }

    public final String NAME;
}
