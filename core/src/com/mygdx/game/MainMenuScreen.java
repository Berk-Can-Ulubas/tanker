package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

import static com.mygdx.game.TankerGdxGame.INSTANCE;

public class MainMenuScreen extends ScreenAdapter {

    public static final int BUTTON_SIZE = 100;

    private Texture playButtonActive;
    private Texture playButtonInactive;
    private Texture settingsButtonActive;
    private Texture settingsButtonInactive;
    private Texture achievementsButtonActive;
    private Texture achievementsButtonInactive;
    private Texture exitButtonActive;
    private Texture exitButtonInactive;

    public MainMenuScreen() {
    }

    @Override
    public void show() {
        INSTANCE.batch = new SpriteBatch();

        // Load the textures
        playButtonActive = new Texture("IconPackByAndelRodis/playbutton_active.png");
        playButtonInactive = new Texture("IconPackByAndelRodis/playbutton_inactive.png");
        settingsButtonActive = new Texture("IconPackByAndelRodis/settings_active.png");
        settingsButtonInactive = new Texture("IconPackByAndelRodis/settings_inactive.png");
        achievementsButtonActive = new Texture("IconPackByAndelRodis/achievement_active.png");
        achievementsButtonInactive = new Texture("IconPackByAndelRodis/achievement_inactive.png");
        exitButtonActive = new Texture("IconPackByAndelRodis/exitdoor_active.png");
        exitButtonInactive = new Texture("IconPackByAndelRodis/exitdoor_inactive.png");
    }

    @Override
    public void render(float delta) {
        INSTANCE.WINDOW_WIDTH = Gdx.graphics.getWidth();
        INSTANCE.WINDOW_HEIGHT = Gdx.graphics.getHeight();

        ScreenUtils.clear(0.169f, 0.749f, 0.416f, 1f);
        INSTANCE.batch.begin();

        // Draw the buttons
        int x = INSTANCE.WINDOW_WIDTH / 2 - BUTTON_SIZE;
        INSTANCE.batch.draw(playButtonInactive, x, 575, BUTTON_SIZE, BUTTON_SIZE);
        INSTANCE.batch.draw(settingsButtonInactive, x, 450, BUTTON_SIZE, BUTTON_SIZE);
        INSTANCE.batch.draw(achievementsButtonInactive, x, 325, BUTTON_SIZE, BUTTON_SIZE);
        INSTANCE.batch.draw(exitButtonInactive, x, 200, BUTTON_SIZE, BUTTON_SIZE);

        if (Gdx.input.getX() < x + BUTTON_SIZE && Gdx.input.getX() > x && INSTANCE.WINDOW_HEIGHT - Gdx.input.getY() < 575 + BUTTON_SIZE && INSTANCE.WINDOW_HEIGHT - Gdx.input.getY() > 575) {
            INSTANCE.batch.draw(playButtonActive, x, 575, BUTTON_SIZE, BUTTON_SIZE);
        } else if(Gdx.input.getX() < x + BUTTON_SIZE && Gdx.input.getX() > x && INSTANCE.WINDOW_HEIGHT - Gdx.input.getY() < 450 + BUTTON_SIZE && INSTANCE.WINDOW_HEIGHT - Gdx.input.getY() > 450) {
            INSTANCE.batch.draw(settingsButtonActive, x, 450, BUTTON_SIZE, BUTTON_SIZE);
        } else if(Gdx.input.getX() < x + BUTTON_SIZE && Gdx.input.getX() > x && INSTANCE.WINDOW_HEIGHT - Gdx.input.getY() < 325 + BUTTON_SIZE && INSTANCE.WINDOW_HEIGHT - Gdx.input.getY() > 325) {
            INSTANCE.batch.draw(achievementsButtonActive, x, 325, BUTTON_SIZE, BUTTON_SIZE);
        } else if(Gdx.input.getX() < x + BUTTON_SIZE && Gdx.input.getX() > x && INSTANCE.WINDOW_HEIGHT - Gdx.input.getY() < 200 + BUTTON_SIZE && INSTANCE.WINDOW_HEIGHT - Gdx.input.getY() > 200) {
            INSTANCE.batch.draw(exitButtonActive, x, 200, BUTTON_SIZE, BUTTON_SIZE);

        }

        INSTANCE.batch.end();
    }

    @Override
    public void dispose() {
        INSTANCE.batch.dispose();
        playButtonInactive.dispose();
        achievementsButtonInactive.dispose();
        settingsButtonInactive.dispose();
        exitButtonInactive.dispose();
    }

    @Override
    public void hide() {
        this.dispose();
    }
}
