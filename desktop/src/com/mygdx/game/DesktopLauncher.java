package com.mygdx.game;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.TankerGdxGame;

import static com.mygdx.game.TankerGdxGame.INSTANCE;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {



	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Tanker");
		config.setResizable(true);
		config.useVsync(true);
		config.setMaximized(true);
		config.setWindowIcon(Files.FileType.Internal, "KenneyTanksPack/tanks_tankGreen1.png");
		new Lwjgl3Application(new TankerGdxGame(), config);

	}
}
