package com.tankstars.Helpers;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.tankstars.Screens.GameScreen;
import static com.tankstars.Helpers.Constants.PPM;

public class TileMapHelper {
    private TiledMap tiledMap;
    private GameScreen game;

    public TileMapHelper(GameScreen game) {
        this.game = game;
    }

    public OrthogonalTiledMapRenderer setupMap() {
        tiledMap = new TmxMapLoader().load("assets/tiledMaps/gamescreen1.tmx");
        parseObjects(tiledMap.getLayers().get("ground_object").getObjects());
        return new OrthogonalTiledMapRenderer(tiledMap);
    }

    private void parseObjects(MapObjects mapObjects) {
        for (MapObject mapObject : mapObjects.getByType(PolygonMapObject.class)) {
            createStaticBody((PolygonMapObject) mapObject);
        }
    }

    private void createStaticBody(PolygonMapObject object) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyType.StaticBody;
        Body body = game.getWorld().createBody(bodyDef);
        Shape shape = createPolygonShape(object);
        body.createFixture(shape, 1000);
        shape.dispose();
    }

    private Shape createPolygonShape(PolygonMapObject object) {
        
        float[] vertices = object.getPolygon().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length / 2];

        int j = 0;
        worldVertices[j] = new Vector2(vertices[0] / PPM, vertices[1] / PPM);

        for (int i = 1; i < worldVertices.length; i++) {
            j = worldVertices.length - i;
            worldVertices[j] = new Vector2(vertices[i * 2] / PPM, vertices[i * 2 + 1] / PPM);
        }

        PolygonShape shape = new PolygonShape();
        shape.set(worldVertices);
        return shape;
    }
}
