package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Tank2 implements Screen {
    MyGdxGame game;
    Sound click;
    Texture tank1;
    Texture tank2;
    Texture tank3;
    Texture tankoutline;
    Texture background;
    Texture logo;
    Texture battle;
    Texture battlet;
    Texture back;
    Texture backt;
    Texture downwall;
    Texture spectre;
    Texture abrams;
    Texture buratino;



    public Tank2(MyGdxGame game){
        this.game = game;
        this.tank1 = new Texture("assets/tank1.png");
        this.tank2 = new Texture("assets/tank2.png");
        this.tank3 = new Texture("assets/tank3.png");
        this.tankoutline = new Texture("assets/tankoutline.png");
        this.background = new Texture("assets/tankselectbg.png");
        this.logo = new Texture("assets/selecttank.png");
        this.battle = new Texture("assets/battle.png");
        this.battlet = new Texture("assets/battlet.png");
        this.back = new Texture("assets/back.png");
        this.backt = new Texture("assets/backt.png");
        this.downwall = new Texture("assets/downwall.jpg");
        this.spectre = new Texture("assets/spectre.png");
        this.buratino = new Texture("assets/buratino.png");
        this.abrams = new Texture("assets/abrrams.png");
        this.click = Gdx.audio.newSound(Gdx.files.internal("assets/click.wav"));
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        game.batch.draw(background,0,0, 1080, 600);
        game.batch.draw(downwall, 0, -30);
        game.batch.draw(tank1, -100, 0, 500, 180);
        game.batch.draw(tank2, 300, 0, 500, 170);
        game.batch.draw(tank3, 700, 0, 500, 180);
        game.batch.draw(logo, 300, 420, 250, 250);
        game.batch.draw(back, 0, 500, 100, 100);
        game.batch.draw(battle, 840, 420, 250, 250);
        game.batch.draw(tank2, -70, 135, 1000, 360);
        game.batch.draw(buratino, 750, 120, 400, 400);

        if (Gdx.input.getX()>25 && Gdx.input.getX() <290 && Gdx.input.getY()>445 && Gdx.input.getY()<590){
            game.batch.draw(tankoutline, -35, -110, 420, 370);
            if(Gdx.input.isTouched()){

                this.click.play();
                game.setScreen(new Tank1(game));

            }
        }
        if (Gdx.input.getX()>425 && Gdx.input.getX() <690 && Gdx.input.getY()>445 && Gdx.input.getY()<590){
            game.batch.draw(tankoutline, 365, -110, 420, 370);
            if(Gdx.input.isTouched()){

                this.click.play();


            }
        }
        if (Gdx.input.getX()>800 && Gdx.input.getX() <1070 && Gdx.input.getY()>445 && Gdx.input.getY()<590){
            game.batch.draw(tankoutline, 745, -110, 420, 370);
            if(Gdx.input.isTouched()){

                this.click.play();
                game.setScreen(new Tank3(game));
//                game.setScreen(new GameMainScreen(game));

            }
        }
        if (Gdx.input.getX()>18 && Gdx.input.getX() <74 && Gdx.input.getY()>24 && Gdx.input.getY()<70){
            game.batch.draw(backt, 0, 500, 100, 100);
            if(Gdx.input.isTouched()){

                this.click.play();
                game.setScreen(new Optionmenu(game));

            }
        }
        if (Gdx.input.getX()>870 && Gdx.input.getX() <1045 && Gdx.input.getY()>16 && Gdx.input.getY()<80){
            game.batch.draw(battlet, 840, 420, 250, 250);
            if(Gdx.input.isTouched()){

                this.click.play();
                game.setScreen(new BattleGround(game));
//                game.setScreen(new GameMainScreen(game));

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
