package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TankerGdxGame extends Game {

	public static TankerGdxGame INSTANCE;
	public static int WINDOW_WIDTH; // 854x480 is a 16:9 aspect ratio
	public static int WINDOW_HEIGHT;
	public SpriteBatch batch;

	public TankerGdxGame() {
		INSTANCE = this;
	}
	
	@Override
	public void create () {
		setScreen(new MainMenuScreen());
		WINDOW_WIDTH = Gdx.graphics.getWidth();
		WINDOW_HEIGHT = Gdx.graphics.getHeight();
	}
}
