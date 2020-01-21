package com.mygdx.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class FinishScreen extends ScreenAdapter {

    private ControlGame game;
    private BitmapFont font, font2;
    private Texture background;

    public FinishScreen(ControlGame game) {
        this.game = game;
    }

    @Override
    public void show(){
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(2, 2);

        font2 = new BitmapFont();
        font2.setColor(Color.WHITE);

        background = new Texture(Gdx.files.internal("game_over.jpg"));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(background, 0 , 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        font2.draw(game.batch, "¡Pulsa la pantalla para volver a jugar!", Gdx.graphics.getWidth() * .350f, Gdx.graphics.getHeight() * .20f);

        if (Gdx.input.isTouched()) {
            game.setScreen(new MyGdxDrop(game));
            dispose();
        }

        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}