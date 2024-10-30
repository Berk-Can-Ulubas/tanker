package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

import static com.mygdx.game.TankerGdxGame.INSTANCE;

public class MainMenuScreen extends ScreenAdapter {

    public static final int BUTTON_SIZE = 100;

    private Texture playButton;
    private Texture settingsButton;
    private Texture achievementsButton;
    private Texture exitButton;

    public MainMenuScreen() {
    }

    @Override
    public void show() {
        INSTANCE.batch = new SpriteBatch();

        // Load the textures
        playButton = new Texture("IconPackByAndelRodis/playbutton.png");
        settingsButton = new Texture("IconPackByAndelRodis/settings.png");
        achievementsButton = new Texture("IconPackByAndelRodis/achievement.png");
        exitButton = new Texture("IconPackByAndelRodis/exitdoor.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.169f, 0.749f, 0.416f, 1f);
        INSTANCE.batch.begin();

        // Draw the buttons
        int x = INSTANCE.WINDOW_WIDTH / 2 - BUTTON_SIZE;
        INSTANCE.batch.draw(playButton, x, 575, BUTTON_SIZE, BUTTON_SIZE);
        INSTANCE.batch.draw(settingsButton, x, 450, BUTTON_SIZE, BUTTON_SIZE);
        INSTANCE.batch.draw(achievementsButton, x, 325, BUTTON_SIZE, BUTTON_SIZE);
        INSTANCE.batch.draw(exitButton, x, 200, BUTTON_SIZE, BUTTON_SIZE);

        INSTANCE.batch.end();
    }

    @Override
    public void dispose() {
        INSTANCE.batch.dispose();
        playButton.dispose();
        achievementsButton.dispose();
        settingsButton.dispose();
        exitButton.dispose();
    }

    @Override
    public void hide() {
        this.dispose();
    }
}
