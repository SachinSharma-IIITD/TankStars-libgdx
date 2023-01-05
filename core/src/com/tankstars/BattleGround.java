package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class BattleGround implements Screen {

    MyGdxGame game;
    Texture back;
    Texture backt;
    Texture ground;
    Sound click;
    Texture tank;
    Texture tank2;


    public BattleGround(MyGdxGame game){
        this.game= game;
        this.back= new Texture("assets/back.png");
        this.backt= new Texture("assets/backt.png");
        this.ground= new Texture("assets/tempgame.png");
        this.click = Gdx.audio.newSound(Gdx.files.internal("assets/click.wav"));
        this.tank= new Texture("assets/tank1.png");
        this.tank2 = new Texture("assets/tank22.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(ground, 0,0, 1080, 600);
        game.batch.draw(back, 0, 500, 100, 100);
        game.batch.draw(tank ,-70 ,90, 400, 100);
        game.batch.draw(tank2, 510, 40, 400, 100);
        if (Gdx.input.getX()>18 && Gdx.input.getX() <74 && Gdx.input.getY()>24 && Gdx.input.getY()<70) {
            game.batch.draw(backt, 0, 500, 100, 100);
            if (Gdx.input.isTouched()) {

                this.click.play();
                game.setScreen(new PauseGame(game));
            }
        }

        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
