package com.tankstars.Helpers;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.tankstars.Objects.Player.Player;

import static com.tankstars.Helpers.Constants.PPM;

public class Factory {
    
    private static Factory instance;
    private Factory() {}

    public static Factory getFactory() {
        if (instance == null) return new Factory();
        else return instance;
    }

    public Body createBody(float x, float y, float width, float height, boolean isStatic, World world, Player player) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x / PPM, y / PPM);
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body.createFixture(fixtureDef).setUserData(player);;
        shape.dispose();

        return body;
    }

}
