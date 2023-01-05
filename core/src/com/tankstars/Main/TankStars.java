package com.tankstars.Main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tankstars.Screens.GameScreen;

public class TankStars extends Game {
 	public static final int W_WIDTH = 1080;
 	public static final int W_HEIGHT = 600;
	public SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
