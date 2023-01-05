package com.tankstars;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.tankstars.Main.TankStars;
import com.tankstars.Helpers.Constants;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("TankStars");
		config.setForegroundFPS(Constants.FPS);
		config.useVsync(true);
		config.setWindowedMode(1080, 600);
		new Lwjgl3Application(new MyGdxGame(), config);
	}
}
