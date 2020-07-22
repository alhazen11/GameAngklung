package angklung.universitaspertamina.ac.id.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

import angklung.universitaspertamina.ac.id.Constants;
import angklung.universitaspertamina.ac.id.Data.Song;
import angklung.universitaspertamina.ac.id.MainGame;
import angklung.universitaspertamina.ac.id.ParallaxBackground;

public class PianoScreen extends BaseScreen{
    private Stage stage;
    private Stage stage2;
    private Song lagu;
    private Image logo;
    private int size_x_6=-65;
    private TextButton button[]= new TextButton[25];
    private TextButton.TextButtonStyle textButtonStyle,textButtonStyle_black;
    private Array<Texture> textures;
    private ParallaxBackground parallaxBackground;
    Group group = new Group();

    public void pickdown(int tone){
        int judul = 0;
        switch (tone){
            case 0:judul = 6;break;
            case 11:judul = 7;break;
            case 1:judul = 8;break;
            case 12:judul = 9;break;
            case 2:judul = 10;break;
            case 3:judul = 11;break;
            case 13:judul = 12;break;
            case 4:judul = 13;break;
            case 14:judul = 14;break;
            case 5:judul = 3;break;
            case 15:judul = 4;break;
            case 6:judul = 5;break;
            case 7:judul = 18;break;
            case 16:judul = 19;break;
            case 8:judul = 30;break;
            case 17:judul = 30;break;
            case 9:judul = 34;break;
            case 10:judul = 35;break;

        }
        lagu.play(judul+42);
    }

    public PianoScreen(final MainGame game,Song lagus) {
        super(game);
        if(game.tipe) {
            game.handler.setOrientationLandscape();
        }
        this.lagu=lagus;
        lagu.stop_bg();
        stage = new Stage(new FitViewport(Constants.WIDTH_H, Constants.HEIGHT_H));
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Constants.font_style(24);
        textButtonStyle.down=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/tuts_w_d.png", Texture.class)));
        textButtonStyle.up= new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/tuts_w.png", Texture.class)));

        textButtonStyle_black = new TextButton.TextButtonStyle();
        textButtonStyle_black.font = Constants.font_style(24);
        textButtonStyle_black.down=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/tuts_b_d.png", Texture.class)));
        textButtonStyle_black.up= new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/tuts_b.png", Texture.class)));
        group = new Group();

        textures = new Array<Texture>();
        for(int i = 1; i <=2;i++){
            textures.add(game.getManager().get("img/bg2.png", Texture.class));
            textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }

        parallaxBackground = new ParallaxBackground(textures, Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSize(Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSpeed(1);
        stage.addActor(parallaxBackground);

        logo = new Image(game.getManager().get("img/logo.png", Texture.class));
        button[18] = new TextButton("Back", textButtonStyle);
        button[18].setSize(125, 60);
        button[18].setPosition(   button[18].getWidth() / 2,  650);

        button[18].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                lagu.stop_bg();
                game.setScreen(new MenuScreen(game));
                return true;
            }
        });
        stage.addActor(button[18]);
        for(int i=0; i<10; i++) {
            button[i] = new TextButton("", textButtonStyle);
            button[i].setSize(120, 400);
            button[i].setPosition(size_x_6 + button[i].getWidth() / 2 ,  0);
            final int finalI = i;
            button[i].addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Tag", "Debug Down");
                    pickdown(finalI);
                    return true;
                }
            });
            size_x_6+=10+button[i].getWidth();
            stage.addActor(button[i]);
        }
        for(int i=10; i<17; i++) {
            button[i] = new TextButton("", textButtonStyle_black);
            button[i].setSize(102, 268);
            button[i].setPosition(size_x_6 + button[i].getWidth() / 2 ,  132);
            final int finalI = i;
            button[i].addListener(new ClickListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Tag", "Debug Down");
                    pickdown(finalI);
                    return true;
                }
            });
            if(i==12 || i==15){
                size_x_6+=button[i].getWidth()*2;
            }if(i==1){
                size_x_6+=65+button[i].getWidth();
            }
            else{
                size_x_6+=65+button[i].getWidth();
            }
            stage.addActor(button[i]);
        }

        logo.setPosition(1294 / 2 - logo.getWidth()/2,  650);
        stage.addActor(logo);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();


    }
}