package com.tankstars.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tankstars.Helpers.Constants;
import com.tankstars.Helpers.TileMapHelper;
import com.tankstars.Main.TankStars;
import com.tankstars.Objects.Player.Player;
import com.tankstars.Scenes.Hud;
import static com.tankstars.Helpers.Constants.PPM;

public class GameScreen implements Screen {

    private TankStars game;
    private SpriteBatch batch;
    private World world;
    private Box2DDebugRenderer debugRenderer;

    private OrthographicCamera camera;
    private Viewport viewport;

    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private TileMapHelper tileMapHelper;
    private Hud hud;

    private Player player;

    public GameScreen(TankStars game) {
        this.game = game;
        this.batch = game.batch;
        this.world = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();
        this.camera = new OrthographicCamera();
        this.viewport = new ExtendViewport(TankStars.W_WIDTH, TankStars.W_HEIGHT, camera);

        this.hud = new Hud(batch);
        this.tileMapHelper = new TileMapHelper(this);
        this.tiledMapRenderer = tileMapHelper.setupMap();

        this.player = new Player(32, 250, 50, 18, new Texture("assets/tanks/tank1/0001.png"), world);
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub

    }

    private void handleInput() {
        player.update();
    }

    private void update() {
        handleInput();

        world.step(1 / Constants.FPS, 6, 2);
        camera.setToOrtho(false);
        batch.setProjectionMatrix(camera.combined);
        camera.update();
        player.update();

        // camera.position.x = player.getBody().getPosition().x;

        tiledMapRenderer.setView(camera);
    }

    @Override
    public void render(float delta) {
        update();

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tiledMapRenderer.render();

        batch.begin();
        player.draw(batch);
        batch.end();

        batch.setProjectionMatrix(hud.getViewport().getCamera().combined);
        hud.getStage().draw();

        debugRenderer.render(world, camera.combined.scl(PPM));
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        tiledMapRenderer.dispose();
        debugRenderer.dispose();
        world.dispose();
    }

    public World getWorld() {
        return world;
    }

}
