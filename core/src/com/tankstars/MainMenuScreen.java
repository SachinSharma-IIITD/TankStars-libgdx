package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class MainMenuScreen implements Screen {
    MyGdxGame game;
    Texture loader;
    Texture tank1;
    Sound click;

//    Texture loader;
//    Texture menuBackground;
//    Texture newGameButton;
//    Texture resumeGameButton;
//    Texture exitButton;
//
//    Skin buttonSkin;
//    TextButton button;
//    Table table;
//    Stage stage;
    public MainMenuScreen(MyGdxGame game){
        this.game=game;
        this.loader= new Texture("assets/loader.png");
        this.tank1 = new Texture("assets/tank1.gif");
        this.click = Gdx.audio.newSound(Gdx.files.internal("assets/click.wav"));
//        buttonSkin = new Skin(Gdx.files.internal("glassy-ui.json"));
//        button = new TextButton("button",buttonSkin,"small");
//        table = new Table();
//        table.add(button).width(100).height(100);
//        table.setPosition(0,0);
//        stage = new Stage();
//        stage.addActor(table);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        game.batch.draw(loader,0,0,1080, 600);
        if(Gdx.input.isTouched()){

            this.click.play();
            game.setScreen(new Optionmenu(game));

        }
        game.batch.end();
//        stage.draw();


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
