package com.tankstars.Objects.Player;

import static com.tankstars.Helpers.Constants.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.tankstars.Helpers.Factory;

public class Player extends GameEntity {

    public Player(float x, float y, float width, float height, Texture texture, World world) {
        super(x, y, width, height, texture, world);
        this.factory = Factory.getFactory();
        this.body = factory.createBody(x, y, width, height, false, world, this);
        this.speed = 10f;

        setBounds(0, 0, 50 / PPM, 18 / PPM);
        setRegion(texture);
    }

    @Override
    public void update() {
        this.x = body.getPosition().x * PPM;
        this.y = body.getPosition().y * PPM;
        handleInput();
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }

    private void handleInput() {
        velX = 0;
        

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            // System.out.println("RIGHT");
        velX = 1;
        // body.applyLinearImpulse(new Vector2(0.8f, 0), body.getPosition(), true);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            // System.out.println("LEFT");
        velX = -1;
        body.applyLinearImpulse(new Vector2(-0.8f, 0), body.getPosition(), true);
        body.setLinearVelocity(velX * speed, 0);
    }

    public Body getBody() {
        return body;
    }

}
