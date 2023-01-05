package com.tankstars.Scenes.SceneResources;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tankstars.Main.TankStars;

public class HealthBar extends Actor {

    private int BAR_LENGTH = (int) (TankStars.W_WIDTH / 4);
    private int BAR_HEIGHT = 20;

    private TextureRegion bar;
    private float health;

    public HealthBar() {
        this.health = 1f;

        Texture t;
        t = new Texture("textures/loader_line_new.png");
        this.bar = new TextureRegion(t, (int)(BAR_LENGTH * health), BAR_HEIGHT);

        setBounds(bar.getRegionX(), bar.getRegionY(),
                bar.getRegionWidth(), bar.getRegionHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);

        batch.draw(bar, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

}
