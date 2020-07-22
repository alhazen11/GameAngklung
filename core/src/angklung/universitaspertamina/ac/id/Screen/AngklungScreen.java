package angklung.universitaspertamina.ac.id.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import angklung.universitaspertamina.ac.id.Constants;
import angklung.universitaspertamina.ac.id.Data.Song;
import angklung.universitaspertamina.ac.id.MainGame;
import angklung.universitaspertamina.ac.id.ParallaxBackground;

public class AngklungScreen extends BaseScreen{
    private Stage stage;
    private int pick[] = new int[3];
    private Image bg,angklung;
    private TextButton button[]= new TextButton[5];
    private Label picks;
    private TextButton.TextButtonStyle textButtonStyle;
    private  Label.LabelStyle labelStyle;
    private Array<Texture> textures;
    private ParallaxBackground parallaxBackground;
    private SequenceAction overallSequence;
    private MoveToAction moveBottomLeftAction,moveBottomCenterAction,moveBottomRightAction;
    private RepeatAction infiniteLoop;
    private int tone;
    private OrthographicCamera camera;
    private float accelX,accelY,accelZ;
    private float last_x, last_y, last_z;
    public int kode=0,kodedash=0,kode2=0,kodedash2=0, kode3=0,kodedash3=0;
    private long lastUpdate = 0;
    private float speed;
    private static final int SHAKE_THRESHOLD = 25;
    private Song lagu;
    private int count=0;

    public AngklungScreen(final MainGame game, final int pick[]) {
        super(game);
        if(game.tipe){
            game.handler.setOrientationPortrait();
        }
        lagu = new Song(game);
        this.pick = pick;
        tone=pick[0];
        camera = new OrthographicCamera();
        stage = new Stage(new FitViewport(Constants.HEIGHT_H, Constants.WIDTH_H,camera));
        textures = new Array<Texture>();
        for(int i = 1; i <=2;i++){
            textures.add(game.getManager().get("img/bg.png", Texture.class));
            textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }

        parallaxBackground = new ParallaxBackground(textures,Constants.HEIGHT_H,Constants.WIDTH_H);
        parallaxBackground.setSize(Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSpeed(1);
        stage.addActor(parallaxBackground);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Constants.font_style(28);
        textButtonStyle.down=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/nada_h.png", Texture.class)));
        textButtonStyle.up= new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/nada.png", Texture.class)));

        labelStyle = new Label.LabelStyle();
        labelStyle.font =  Constants.font_style(38);;

        picks = new Label("Selected tone : " + Constants.node(tone) ,labelStyle);
        picks.setPosition(Constants.HEIGHT_H/2-picks.getWidth()/2,  Constants.WIDTH_H-270);
        picks.setWrap(true);
        picks.setAlignment(Align.center);

        stage.addActor(picks);
        button[4] = new TextButton("Back", textButtonStyle);
        button[4].setSize(125, 60);
        button[4].setPosition(  button[4].getWidth() / 2,  50);

        button[4].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                game.setScreen(new MenuScreen(game));
                return true;
            }
        });
        stage.addActor(button[4]);
        button[3] = new TextButton("Centok", textButtonStyle);
        button[3].setSize(250, 80);
        button[3].setPosition(   Constants.HEIGHT_H/2-button[3].getWidth() / 2,  200);

        stage.addActor(button[3]);
        button[2] = new TextButton(""+Constants.node(pick[0]), textButtonStyle);
        button[2].setSize(200, 80);
        button[2].setPosition(   50,  Constants.WIDTH_H-150);
        button[2].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                tone=pick[0];
                return true;
            }
        });
        button[1] = new TextButton(""+Constants.node(pick[1]), textButtonStyle);
        button[1].setSize(200, 80);
        button[1].setPosition(   300,  Constants.WIDTH_H-150);
        button[1].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                tone=pick[1];
                return true;
            }
        });
        button[0] = new TextButton(""+Constants.node(pick[2]), textButtonStyle);
        button[0].setSize(200, 80);
        button[0].setPosition(   550,  Constants.WIDTH_H-150);
        button[0].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                tone=pick[2];
                return true;
            }
        });
        stage.addActor(button[2]);
        stage.addActor(button[1]);
        stage.addActor(button[0]);
        angklung = new Image(game.getManager().get("img/angkung.png", Texture.class));
        angklung.setPosition(Constants.HEIGHT_H/2-angklung.getWidth()/2,  Constants.WIDTH_H/2-angklung.getHeight()/2);
        stage.addActor(angklung);
        button[3].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                lagu.play(tone);
                return true;
            }
        });
        moveBottomRightAction = new MoveToAction();
        moveBottomRightAction.setPosition(Constants.HEIGHT_H/2-angklung.getWidth()/2 + 100,  Constants.WIDTH_H/2-angklung.getHeight()/2);
        moveBottomRightAction.setDuration(1);
        moveBottomRightAction.setInterpolation(Interpolation.smooth);
        moveBottomLeftAction = new MoveToAction();
        moveBottomLeftAction.setPosition(Constants.HEIGHT_H/2-angklung.getWidth()/2 - 100,  Constants.WIDTH_H/2-angklung.getHeight()/2);
        moveBottomLeftAction.setDuration(1);
        moveBottomLeftAction.setInterpolation(Interpolation.smooth);
        moveBottomCenterAction = new MoveToAction();
        moveBottomCenterAction.setPosition(Constants.HEIGHT_H/2-angklung.getWidth()/2,  Constants.WIDTH_H/2-angklung.getHeight()/2);
        moveBottomCenterAction.setDuration(1);
        moveBottomCenterAction.setInterpolation(Interpolation.smooth);
        overallSequence = new SequenceAction();
        overallSequence.addAction(moveBottomRightAction);
        overallSequence.addAction(moveBottomLeftAction);
        overallSequence.addAction(moveBottomCenterAction);


        infiniteLoop = new RepeatAction();
        infiniteLoop.setCount(RepeatAction.FOREVER);
        infiniteLoop.setAction(overallSequence);
        angklung.addAction(infiniteLoop);

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
        picks.setText("Selected tone : "+ Constants.node(tone));
        picks.setAlignment(Align.center);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        accelX = Gdx.input.getAccelerometerX();
        accelY = Gdx.input.getAccelerometerY();
        accelZ = Gdx.input.getAccelerometerZ();
            speed = Math.abs(accelX + accelY + accelZ - last_x - last_y - last_z);
            if (speed > SHAKE_THRESHOLD) {
                count += 1;
                Gdx.app.log("Tag", "Debug Down" + count  +tone);
                if (count % 3 == 0) {
                    count = 0;
                    lagu.play(tone+42);

                }
            }
            last_x = accelX;
            last_y = accelY;
            last_z = accelZ;


    }
}
