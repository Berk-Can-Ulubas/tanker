package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.mygdx.game.TankerGdxGame.*;

public class MainMenuScreen extends ScreenAdapter {

    private Texture playButton;
    private Texture playButtonInactive;
    private Texture settingsButton;
    private Texture settingsButtonInactive;
    private Texture achievementsButton;
    private Texture achievementsButtonInactive;
    private Texture exitButton;
    private Texture exitButtonInactive;

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
        // Use the updated dimensions
        int windowWidth = WINDOW_WIDTH;
        int windowHeight = WINDOW_HEIGHT;
        int buttonSize = windowHeight / 12;

        ScreenUtils.clear(0.329f, 0.49f, 0.51f, 0.471f);

        INSTANCE.batch.begin();

        // Draw the buttons
        int x = windowWidth / 2 - buttonSize / 2;
        int y1 = (1 * windowHeight / 4) - (3 * buttonSize / 2);
        int y2 = (1 * windowHeight / 2) - (3 * buttonSize / 2);
        int y3 = (3 * windowHeight / 4) - (3 * buttonSize / 2);
        int y4 = (4 * windowHeight / 4) - (3 * buttonSize / 2);

        INSTANCE.batch.draw(playButton, x, y4, buttonSize, buttonSize);
        INSTANCE.batch.draw(settingsButton, x, y3, buttonSize, buttonSize);
        INSTANCE.batch.draw(achievementsButton, x, y2, buttonSize, buttonSize);
        INSTANCE.batch.draw(exitButton, x, y1, buttonSize, buttonSize);

        if (Gdx.input.getX() < x + buttonSize && Gdx.input.getX() > x && windowHeight - Gdx.input.getY() < y4 + buttonSize && windowHeight - Gdx.input.getY() > y4) {
            INSTANCE.batch.draw(playButton, x, y4, buttonSize, buttonSize);
        } else if (Gdx.input.getX() < x + buttonSize && Gdx.input.getX() > x && windowHeight - Gdx.input.getY() < y3 + buttonSize && windowHeight - Gdx.input.getY() > y3) {
            INSTANCE.batch.draw(settingsButton, x, y3, buttonSize, buttonSize);
        } else if (Gdx.input.getX() < x + buttonSize && Gdx.input.getX() > x && windowHeight - Gdx.input.getY() < y2 + buttonSize && windowHeight - Gdx.input.getY() > y2) {
            INSTANCE.batch.draw(achievementsButton, x, y2, buttonSize, buttonSize);
        } else if (Gdx.input.getX() < x + buttonSize && Gdx.input.getX() > x && windowHeight - Gdx.input.getY() < y1 + buttonSize && windowHeight - Gdx.input.getY() > y1) {
            INSTANCE.batch.draw(exitButton, x, y1, buttonSize, buttonSize);
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

