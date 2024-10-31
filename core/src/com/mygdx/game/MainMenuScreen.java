package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import space.earlygrey.shapedrawer.ShapeDrawer;

import java.awt.*;

import static com.mygdx.game.TankerGdxGame.INSTANCE;

public class MainMenuScreen extends ScreenAdapter {

    private Texture playButtonActive;
    private Texture playButtonInactive;
    private Texture settingsButtonActive;
    private Texture settingsButtonInactive;
    private Texture achievementsButtonActive;
    private Texture achievementsButtonInactive;
    private Texture exitButtonActive;
    private Texture exitButtonInactive;

   private ShapeRenderer shape = new ShapeRenderer();

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
        // Use the updated dimensions
        int windowWidth = INSTANCE.WINDOW_WIDTH;
        int windowHeight = INSTANCE.WINDOW_HEIGHT;
        int buttonSize = windowHeight / 12;

        ScreenUtils.clear(0.169f, 0.749f, 0.416f, 1f);

        // Draw a rectangle
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(0, 0, 1, 1f);
        int rectWidth = windowWidth / 4;
        int rectHeight = windowHeight / 2;
        shape.rect(windowWidth / 2 - rectWidth / 2, windowHeight / 2 - rectHeight / 2, rectWidth, rectHeight);
        shape.end();

        INSTANCE.batch.begin();

        // Draw the buttons
        int x = windowWidth / 2 - buttonSize / 2;
        int y1 = (1 * windowHeight / 4) - (3 * buttonSize / 2);
        int y2 = (1 * windowHeight / 2) - (3 * buttonSize / 2);
        int y3 = (3 * windowHeight / 4) - (3 * buttonSize / 2);
        int y4 = (4 * windowHeight / 4) - (3 * buttonSize / 2);

        INSTANCE.batch.draw(playButtonInactive, x, y4, buttonSize, buttonSize);
        INSTANCE.batch.draw(settingsButtonInactive, x, y3, buttonSize, buttonSize);
        INSTANCE.batch.draw(achievementsButtonInactive, x, y2, buttonSize, buttonSize);
        INSTANCE.batch.draw(exitButtonInactive, x, y1, buttonSize, buttonSize);

        if (Gdx.input.getX() < x + buttonSize && Gdx.input.getX() > x && windowHeight - Gdx.input.getY() < y4 + buttonSize && windowHeight - Gdx.input.getY() > y4) {
            INSTANCE.batch.draw(playButtonActive, x, y4, buttonSize, buttonSize);
        } else if (Gdx.input.getX() < x + buttonSize && Gdx.input.getX() > x && windowHeight - Gdx.input.getY() < y3 + buttonSize && windowHeight - Gdx.input.getY() > y3) {
            INSTANCE.batch.draw(settingsButtonActive, x, y3, buttonSize, buttonSize);
        } else if (Gdx.input.getX() < x + buttonSize && Gdx.input.getX() > x && windowHeight - Gdx.input.getY() < y2 + buttonSize && windowHeight - Gdx.input.getY() > y2) {
            INSTANCE.batch.draw(achievementsButtonActive, x, y2, buttonSize, buttonSize);
        } else if (Gdx.input.getX() < x + buttonSize && Gdx.input.getX() > x && windowHeight - Gdx.input.getY() < y1 + buttonSize && windowHeight - Gdx.input.getY() > y1) {
            INSTANCE.batch.draw(exitButtonActive, x, y1, buttonSize, buttonSize);
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
    public void resize(int width, int height) {
        INSTANCE.WINDOW_WIDTH = width;
        INSTANCE.WINDOW_HEIGHT = height;
    }

    @Override
    public void hide() {
        this.dispose();
    }
}
