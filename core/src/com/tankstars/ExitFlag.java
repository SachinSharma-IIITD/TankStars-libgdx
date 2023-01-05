package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class ExitFlag implements Screen {
    MyGdxGame game;
    Sound click;
    Texture tank1;
    Texture tank2;
    Texture tank3;
    Texture logo;
    Texture newbutton;
    Texture newtouched;
    Texture resume;
    Texture resumet;
    Texture exit;
    Texture exitt;

    Texture sidewall;
    Texture backButton;
    Texture exitwall;
    Texture yes;
    Texture no;
    Texture yest;
    Texture not;
//    private Stage stage;

    public ExitFlag(MyGdxGame game){
        this.game=game;
        this.tank1= new Texture("assets/tank1.gif");
        this.sidewall=new Texture("assets/sidewall.png");
        this.exit= new Texture("assets/exit.png");
        this.exitt = new Texture("assets/exittouched.png");
        this.newbutton= new Texture("assets/newgame.png");
        this.newtouched = new Texture("assets/newgametouched.png");
        this.resume= new Texture("assets/resume.png");
        this.resumet = new Texture("assets/resumetouched.png");
        this.logo= new Texture("assets/logo.png");
        this.click = Gdx.audio.newSound(Gdx.files.internal("assets/click.wav"));
        this.exitwall= new Texture("assets/exitwall.png");
        this.yes= new Texture("assets/yes.png");
        this.yest= new Texture("assets/yest.png");
        this.no= new Texture("assets/no.png");
        this.not= new Texture("assets/not.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(tank1, 0, 0, 680, 600);
        game.batch.draw(sidewall, 630, -80, 600, 800);
        game.batch.draw(newbutton, 645, 250, 500, 300);
        game.batch.draw(resume, 645, 150, 500, 300);
        game.batch.draw(exit, 645, 50, 500, 300);
        game.batch.draw(logo, 200, 371, 300, 200);
        game.batch.draw(exitwall, 50,10 , 750, 550);
        game.batch.draw(yes, 100, 135, 300, 300);
        game.batch.draw(no, 450, 135, 300, 300);




        if(Gdx.input.getX()>160 && Gdx.input.getX() <310 && Gdx.input.getY()>320 && Gdx.input.getY()<370){
            game.batch.draw(yest, 100, 135, 300, 300);
            if(Gdx.input.isTouched()){
                this.click.play();
                Gdx.app.exit();
            }
                }
        if(Gdx.input.getX()>510 && Gdx.input.getX() <660 && Gdx.input.getY()>320 && Gdx.input.getY()<370){
            game.batch.draw(not, 450, 135, 300, 300);
            if(Gdx.input.isTouched()){
                this.click.play();
                game.setScreen(new Optionmenu(game));
            }
        }


//                game.setScreen(new GameMainScreen(game));



        game.batch.end();
//        stage.act();
//        stage.draw();
//        Gdx.input.setInputProcessor(stage);
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
