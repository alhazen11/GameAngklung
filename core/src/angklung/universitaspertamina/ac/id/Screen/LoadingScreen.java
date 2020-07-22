package angklung.universitaspertamina.ac.id.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import angklung.universitaspertamina.ac.id.Constants;
import angklung.universitaspertamina.ac.id.MainGame;
import angklung.universitaspertamina.ac.id.ParallaxBackground;

public class LoadingScreen extends BaseScreen {
    private Stage stage;
    private Label loading;
    private Array<Texture> textures;
    private ParallaxBackground parallaxBackground;
    private Image logo;
    public LoadingScreen(MainGame game) {
        super(game);
        if(game.tipe) {
        game.handler.setOrientationLandscape();
        }
        stage = new Stage(new FitViewport(Constants.WIDTH_H, Constants.HEIGHT_H));
        logo = new Image(new Texture(Gdx.files.internal("img/logo.png")));

        LabelStyle labelStyle = new LabelStyle(Constants.font_style(14),Color.WHITE);
        loading = new Label("Loading...",labelStyle);
        loading.setPosition( Constants.WIDTH_H / 2 - loading.getWidth()/2,  Constants.HEIGHT_H / 2);
        loading.setFontScale(3);
        loading.setAlignment(2);
        logo.setPosition(Constants.WIDTH_H / 2 - logo.getWidth()/2,  Constants.HEIGHT_H / 2  + 100);
        textures = new Array<Texture>();
        for(int i = 1; i <=2;i++){
            textures.add(new Texture(Gdx.files.internal("img/bg2.png")));
            textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }

        parallaxBackground = new ParallaxBackground(textures,Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSize(Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSpeed(1);
        stage.addActor(parallaxBackground);        stage.addActor(loading);
        stage.addActor(logo);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (game.getManager().update()) {
            game.finishLoading();
        } else {
            int progress = (int) (game.getManager().getProgress() * 100);
            loading.setText("Loading... " + progress + "%");
        }
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
