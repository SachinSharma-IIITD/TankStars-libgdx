package com.tankstars.Scenes.SceneResources;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tankstars.Main.TankStars;

public class HealthBarBack extends Actor {

    private int BAR_LENGTH = (int) (TankStars.W_WIDTH / 4);
    private int BAR_HEIGHT = 20;

    private TextureRegion barPad;

    public HealthBarBack() {

        Texture t;
        t = new Texture("textures/loader_pad_new.png");
        this.barPad = new TextureRegion(t, BAR_LENGTH+20, BAR_HEIGHT+20);

        setBounds(barPad.getRegionX(), barPad.getRegionY(),
                barPad.getRegionWidth(), barPad.getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);

        batch.draw(barPad, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

}
