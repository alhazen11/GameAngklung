package angklung.universitaspertamina.ac.id.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

import angklung.universitaspertamina.ac.id.Constants;
import angklung.universitaspertamina.ac.id.Data.Song;
import angklung.universitaspertamina.ac.id.MainGame;
import angklung.universitaspertamina.ac.id.ParallaxBackground;

public class MenuScreen extends BaseScreen{
    private Stage stage;

    private Image logo;
    private TextButton button,button2,button3,button4,button6;
    private ImageButton button5;
    private ImageButton.ImageButtonStyle textButtonStyle2;
    private TextButton.TextButtonStyle textButtonStyle;
    private Array<Texture> textures;
    private ParallaxBackground parallaxBackground;
    public BaseScreen  musicScreen, nadaScreen,highScreen,pianoScreen;
    private Song lagu;
    private boolean sound=true,vib=true;

    public MenuScreen(final MainGame game) {
        super(game);
        if(game.tipe) {
            game.handler.setOrientationLandscape();
        }
        lagu = new Song(game);
        lagu.play_bg();
        stage = new Stage(new FitViewport(Constants.WIDTH_H, Constants.HEIGHT_H));
        textButtonStyle2 = new ImageButton.ImageButtonStyle();
        textButtonStyle2.down=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/nada_h.png", Texture.class)));
        textButtonStyle2.up= new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/nada.png", Texture.class)));
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Constants.font_style(33);
        textButtonStyle.down=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/h_menu.png", Texture.class)));
        textButtonStyle.up= new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/menu.png", Texture.class)));
        button = new TextButton("Play",textButtonStyle);
        button.setSize(483,95);
        button2 = new TextButton("High Score",textButtonStyle);
        button2.setSize(483,95);
        button3 = new TextButton("Virtual Angklung",textButtonStyle);
        button3.setSize(483,95);
        button4 = new TextButton("Exit",textButtonStyle);
        button4.setSize(483,95);
        button6 = new TextButton("Piano",textButtonStyle);
        button6.setSize(483,95);
        button5 = new ImageButton(textButtonStyle2);
        button5.setSize(100,60);
        button5.pad(10,5,10,5);
        button5.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/music_on.png", Texture.class)));
        button5.getStyle().imageChecked = new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/music_mute.png", Texture.class)));
        button.setPosition(Constants.WIDTH_H/2-button.getWidth()/2,Constants.HEIGHT_H/2 + 120);
        button2.setPosition(Constants.WIDTH_H/2-button.getWidth()/2,Constants.HEIGHT_H/2 );
        button3.setPosition(Constants.WIDTH_H/2-button.getWidth()/2,Constants.HEIGHT_H/2 - 120);
        button6.setPosition(Constants.WIDTH_H/2-button.getWidth()/2,Constants.HEIGHT_H/2 - 240);
        button4.setPosition(Constants.WIDTH_H/2-button.getWidth()/2,Constants.HEIGHT_H/2 - 360);

        button5.setPosition(50,50);

        logo = new Image(game.getManager().get("img/logo.png", Texture.class));
        nadaScreen = new NadaScreen(game,lagu);
        musicScreen = new MusicScreen(game,lagu);
        highScreen = new HighscoreScreen(game,lagu);
        pianoScreen =new PianoScreen(game,lagu);
        button.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                game.setScreen(musicScreen);
                return true;
            }
        });
        button2.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                game.setScreen(highScreen);
                return true;
            }
        });
        button3.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                game.setScreen(nadaScreen);
                return true;
            }
        });
        button6.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                game.setScreen(pianoScreen);
                return true;
            }
        });
        button4.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }
        });
        button5.addListener(new InputListener(){
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                if(sound){
                    lagu.pause_bg();
                    sound=false;
                }else {
                    lagu.play_bg();
                    sound=true;
                }
                return true;
            }
        });
       textures = new Array<Texture>();
        for(int i = 1; i <=2;i++){
            textures.add(game.getManager().get("img/bg2.png", Texture.class));
            textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }

        parallaxBackground = new ParallaxBackground(textures,Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSize(Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSpeed(1);
        stage.addActor(parallaxBackground);
        logo.setPosition(1294 / 2 - logo.getWidth()/2,  650);
        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);
        stage.addActor(button5);
        stage.addActor(button6);
        stage.addActor(logo);
    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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