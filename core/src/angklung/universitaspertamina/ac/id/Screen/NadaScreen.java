package angklung.universitaspertamina.ac.id.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

import angklung.universitaspertamina.ac.id.Constants;
import angklung.universitaspertamina.ac.id.Data.Song;
import angklung.universitaspertamina.ac.id.MainGame;
import angklung.universitaspertamina.ac.id.ParallaxBackground;

public class NadaScreen  extends BaseScreen{
    private Stage stage;
    private Song lagu;
    private int size_x_1=20,size_x_2=20,size_x_3=20,size_x_4=20,size_x_5=20,size_x_6=20;
    private int pick[] = new int[3];
    private Image logo;
    private TextButton button[]= new TextButton[44];
    private Label picks;
    private TextButton.TextButtonStyle textButtonStyle;
    private Array<Texture> textures;
    private ParallaxBackground parallaxBackground;
    private  Label.LabelStyle labelStyle;
    public void pick(int picks){
        if(pick[0]==picks){pick[0]=43; }else
        if(pick[1]==picks){pick[1]=43; }else
        if(pick[2]==picks){pick[2]=43; }else{
            if(pick[0]==43){pick[0]=picks;}else
            if(pick[1]==43){pick[1]=picks;}else
            if(pick[2]==43){pick[2]=picks;}else
                if(pick[0]==0){pick[0]=picks;}else
                if(pick[1]==0){pick[1]=picks;}else
                if(pick[2]==0){pick[2]=picks;}
        }
    }
    public String text_pick(){
        return Constants.node(pick[0])+ " " +Constants.node(pick[1])+ " " + Constants.node(pick[2]);
    }

    public NadaScreen(final MainGame game,Song lagus) {
        super(game);
        if(game.tipe) {
            game.handler.setOrientationLandscape();
        }
        this.lagu=lagus;
        lagu.play_bg();
        stage = new Stage(new FitViewport(Constants.WIDTH_H, Constants.HEIGHT_H));
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Constants.font_style(24);
        textButtonStyle.checked=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/nada_h.png", Texture.class)));
        textButtonStyle.down=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/nada_h.png", Texture.class)));
        textButtonStyle.up= new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/nada.png", Texture.class)));
        textures = new Array<Texture>();
        for(int i = 1; i <=2;i++){
            textures.add(game.getManager().get("img/bg2.png", Texture.class));
            textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }

        parallaxBackground = new ParallaxBackground(textures, Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSize(Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSpeed(1);
        stage.addActor(parallaxBackground);
        labelStyle = new Label.LabelStyle();
        labelStyle.font =  Constants.font_style(38);;

        picks = new Label("Selected tone : "+text_pick(),labelStyle);
        picks.setPosition(Constants.WIDTH_H/2-300,  530);
        picks.setWrap(true);
        picks.setAlignment(Align.center);

        stage.addActor(picks);
        button[43] = new TextButton("Back", textButtonStyle);
        button[43].setSize(125, 60);
        button[43].setPosition(size_x_6 + 1015 + button[43].getWidth() / 2,  50);

        button[43].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                lagu.stop_bg();
                game.setScreen(new MenuScreen(game));
                return true;
            }
        });
        stage.addActor(button[43]);
        button[42] = new TextButton("Mulai", textButtonStyle);
        button[42].setSize(125, 60);
        button[42].setPosition(size_x_6 + 870 + button[42].getWidth() / 2,  50);

        button[42].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                lagu.stop_bg();
                game.setScreen(new AngklungScreen(game,pick));
                return true;
            }
        });
        stage.addActor(button[42]);
        logo = new Image(game.getManager().get("img/logo.png", Texture.class));
        for(int i=40; i<42; i++) {
            button[i] = new TextButton(""+Constants.node(i), textButtonStyle);
            button[i].setSize(125, 60);
            button[i].setPosition(size_x_6 + button[i].getWidth() / 2 ,  50);
            final int finalI = i;
            button[i].addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Tag", "Debug Down");
                    pick(finalI);
                    return true;
                }
            });
            size_x_6+=20+button[i].getWidth();
            stage.addActor(button[i]);
        }
        for(int i=32; i<40; i++) {
            button[i] = new TextButton(""+Constants.node(i), textButtonStyle);
            button[i].setSize(125, 60);
            button[i].setPosition(size_x_1 + button[i].getWidth() / 2 ,  120);
            final int finalI = i;
            button[i].addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Tag", "Debug Down");
                    pick(finalI);
                    return true;
                }
            });
            size_x_1+=20+button[i].getWidth();
            stage.addActor(button[i]);
        }
        for(int i=24; i<32; i++) {
            button[i] = new TextButton(""+Constants.node(i), textButtonStyle);
            button[i].setSize(125, 60);
            button[i].setPosition(size_x_2 + button[i].getWidth() / 2 ,  190);
            final int finalI = i;
            button[i].addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Tag", "Debug Down");
                    pick(finalI);
                    return true;
                }
            });
            size_x_2+=20+button[i].getWidth();
            stage.addActor(button[i]);
        }
        for(int i=16; i<24; i++) {
            button[i] = new TextButton(""+Constants.node(i), textButtonStyle);
            button[i].setSize(125, 60);
            button[i].setPosition(size_x_3 + button[i].getWidth() / 2 ,  260);
            final int finalI = i;
            button[i].addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Tag", "Debug Down");
                    pick(finalI);
                    return true;
                }
            });
            size_x_3+=20+button[i].getWidth();
            stage.addActor(button[i]);
        }
        for(int i=8; i<16; i++) {
            button[i] = new TextButton(""+Constants.node(i), textButtonStyle);
            button[i].setSize(125, 60);
            button[i].setPosition(size_x_4 + button[i].getWidth() / 2 ,  330);
            final int finalI = i;
            button[i].addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Tag", "Debug Down");
                    pick(finalI);
                    return true;
                }
            });
            size_x_4+=20+button[i].getWidth();
            stage.addActor(button[i]);
        }
        for(int i=0; i<8; i++) {
            button[i] = new TextButton(""+Constants.node(i), textButtonStyle);
            button[i].setSize(125, 60);
            button[i].setPosition(size_x_5 + button[i].getWidth() / 2 ,  400);
            final int finalI = i;
            button[i].addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Tag", "Debug Down");
                    pick(finalI);
                    return true;
                }
            });
            size_x_5+=20+button[i].getWidth();
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
        picks.setText("Selected tone : "+text_pick());
        picks.setAlignment(Align.center);
        stage.act();
        stage.draw();
    }
}