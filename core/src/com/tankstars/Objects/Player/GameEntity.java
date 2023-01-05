package com.tankstars.Objects.Player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.tankstars.Helpers.Factory;

public abstract class GameEntity extends Sprite{
    
    protected float x, y, velX, velY, speed, width, height;
    protected World world;
    protected Factory factory;
    protected Body body;

    public GameEntity(float x, float y, float width, float height, Texture texture, World world) {
        super(texture);

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velX = 0;
        this.velY = 0;
        this.speed = 0;
        this.world = world;
    }

    public abstract void update();
    // public abstract void render(SpriteBatch batch);
}
