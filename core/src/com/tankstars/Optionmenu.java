package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Optionmenu implements Screen {

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

    public Optionmenu(MyGdxGame game){
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

//        stage = new Stage(new ScreenViewport());
//        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
//        int row_height = Gdx.graphics.getWidth() / 12;
//        int col_width = Gdx.graphics.getWidth() / 12;
//        Button button1 = new TextButton("New Game",mySkin,"small");
//        button1.setSize(col_width*4,row_height);
//        button1.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*3);
//        button1.addListener(new InputListener(){

//            @Override
//            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new GameMainScreen(game));
////                outputLabel.setText("Press a Button");
//                return ;
//            }
//            @Override
//            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                game.setScreen(new GameMainScreen(game));
////                outputLabel.setText("Pressed Text Button");
////                System.out.println();
//                return true;
//
//            }
//        });
//
//        stage.addActor(button1);

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





        if (Gdx.input.getX()>690 && Gdx.input.getX() <1075 && Gdx.input.getY()>165 && Gdx.input.getY()<215){
            game.batch.draw(newtouched, 645, 250, 500, 300);
            if(Gdx.input.isTouched()){

                this.click.play();
                game.setScreen(new Tank1(game));

            }
        }
        if (Gdx.input.getX()>690 && Gdx.input.getX() <1075 && Gdx.input.getY()>265 && Gdx.input.getY()<315){
            game.batch.draw(resumet, 645, 150, 500, 300);
            if(Gdx.input.isTouched()){

                this.click.play();
                game.setScreen(new Tank1(game));

            }
        }
        if (Gdx.input.getX()>690 && Gdx.input.getX() <1075 && Gdx.input.getY()>365 && Gdx.input.getY()<415){
            game.batch.draw(exitt, 645, 50, 500, 300);
            if(Gdx.input.isTouched()){
                this.click.play();
                game.setScreen(new ExitFlag(game));
//               game.setScreen(new GameMainScreen(game));

            }
        }
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
