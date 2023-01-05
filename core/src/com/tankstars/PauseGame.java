package com.tankstars;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class PauseGame implements Screen {

    MyGdxGame game;
    Texture back;
    Texture backt;
    Texture ground;
    Sound click;
    Texture box;
    Texture resume;
    Texture resumet;
    Texture save;
    Texture savet;
    Texture exit;
    Texture exitt;
    Texture tank;
    Texture tank2;

    public PauseGame(MyGdxGame game){
        this.game= game;
        this.back= new Texture("assets/back.png");
        this.backt= new Texture("assets/backt.png");
        this.ground= new Texture("assets/tempgame.png");
        this.click = Gdx.audio.newSound(Gdx.files.internal("assets/click.wav"));
        this.box= new Texture("assets/box.png");
        this.resume = new Texture("assets/resume1.png");
        this.resumet= new Texture("assets/resume1t.png");
        this.save= new Texture("assets/save.png");
        this.savet = new Texture("assets/savet.png");
        this.exit= new Texture("assets/exit1.png");
        this.exitt= new Texture("assets/exit1t.png");
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
        game.batch.draw(box, 350, 200, 370, 400);
        game.batch.draw(resume, 400, 330,250, 250);
        game.batch.draw(save, 400, 250,250, 250);
        game.batch.draw(exit, 400, 170,250, 250);
        game.batch.draw(tank ,-70 ,90, 400, 100);
        game.batch.draw(tank2, 510, 40, 400, 100);

        if (Gdx.input.getX()>439 && Gdx.input.getX() <604 && Gdx.input.getY()>110 && Gdx.input.getY()<170){
            game.batch.draw(resumet, 400, 330,250, 250);
            if(Gdx.input.isTouched()){

                this.click.play();
//                game.setScreen(new Tank1(game));

            }
        }
        if (Gdx.input.getX()>439 && Gdx.input.getX() <604 && Gdx.input.getY()>190 && Gdx.input.getY()<250){
            game.batch.draw(savet, 400, 250,250, 250);
            if(Gdx.input.isTouched()){

                this.click.play();
//                game.setScreen(new Tank1(game));

            }
        }
        if (Gdx.input.getX()>439 && Gdx.input.getX() <604 && Gdx.input.getY()>270 && Gdx.input.getY()<330){
            game.batch.draw(exitt, 400, 170,250, 250);
            if(Gdx.input.isTouched()){

                this.click.play();
                game.setScreen(new Tank1(game));

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
