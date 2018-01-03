package com.dungeon.game.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public enum SkinType {
    Sgx("ui/skin/sgx/sgx-ui.json")
    ;

    SkinType(String skinPath) {
        this.SKIN = new Skin(Gdx.files.internal(skinPath));
    }

    public final Skin SKIN;

}
