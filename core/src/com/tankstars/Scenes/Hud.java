package com.tankstars.Scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tankstars.Main.TankStars;
import com.tankstars.Scenes.SceneResources.HealthBar;
import com.tankstars.Scenes.SceneResources.HealthBarBack;

public class Hud {

    private Stage stage;
    private Viewport viewport;

    private float healthPlayer1;
    private float healthPlayer2;

    public Hud(SpriteBatch batch) {
        
        this.viewport = new FitViewport(TankStars.W_WIDTH, TankStars.W_HEIGHT, new OrthographicCamera());
        this.stage = new Stage(viewport, batch);

        this.healthPlayer1 = 1;
        this.healthPlayer2 = 1;
        
        Label vsLabel = new Label("VS", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Label youLabel = new Label(String.format("%8s", "YOU"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        Label oppLabel = new Label(String.format("%-8s", "OPPONENT"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        HealthBar healthBarPlayer1 = new HealthBar();
        HealthBar healthBarPlayer2 = new HealthBar();

        HealthBarBack healthBarBack1 = new HealthBarBack();
        HealthBarBack healthBarBack2 = new HealthBarBack();

        table.add(youLabel).expandX().pad(10, 80, 10, 0).right();
        table.stack(healthBarBack1, healthBarPlayer1).expandX().pad(10, 0, 10, 0);
        table.add(vsLabel).expandX().pad(10, 0, 10, 0).center();
        table.stack(healthBarBack2, healthBarPlayer2).expandX().pad(10, 0, 10, 0);
        table.add(oppLabel).expandX().pad(10, 0, 10, 80).left();

        stage.addActor(table);
    }

    public Viewport getViewport() {
        return viewport;
    }

    public Stage getStage() {
        return stage;
    }
}
