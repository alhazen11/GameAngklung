package angklung.universitaspertamina.ac.id.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Random;

import angklung.universitaspertamina.ac.id.Constants;
import angklung.universitaspertamina.ac.id.Data.Music;
import angklung.universitaspertamina.ac.id.Data.Score;
import angklung.universitaspertamina.ac.id.Data.Song;
import angklung.universitaspertamina.ac.id.MainGame;
import angklung.universitaspertamina.ac.id.ParallaxBackground;
import angklung.universitaspertamina.ac.id.Tales.Piano;
import angklung.universitaspertamina.ac.id.Tales.Row;

import static angklung.universitaspertamina.ac.id.Tales.Cons.currentVel;
import static angklung.universitaspertamina.ac.id.Tales.Cons.initialVel;
import static angklung.universitaspertamina.ac.id.Tales.Cons.screenX;
import static angklung.universitaspertamina.ac.id.Tales.Cons.screenY;
import static angklung.universitaspertamina.ac.id.Tales.Cons.tileHeight;
public class TilesScreen extends BaseScreen{
    private Stage stage;
    private ShapeRenderer shapeRenderer;

    private Array<Row> rows;

    private float totalTime;

    private int indexInfTiles;

    private int score;

    private Random random;

    private int state;

    private SpriteBatch spriteBatch;

    private Texture texture,bintang1,bintang2,bintang3;
    private Music Musics;
    private Piano piano;
    private OrthographicCamera camera;
    private String fontVel;
    private BitmapFont font;
    private Array<Texture> textures;
    private ParallaxBackground parallaxBackground;
    private GlyphLayout glyphLayout;
    private int judul,statess=1;
    private Image layer1,layer2,layer3,layer4;
    private boolean test=false,finals=false;
    private Song lagu;
    private Score nilai;
    public TilesScreen(MainGame game, int kode,Song lagus) {
        super(game);
        if (game.tipe) {
            game.handler.setOrientationPortrait();
        }
        nilai=new Score();
        Musics=new Music();
        this.lagu=lagus;
        camera = new OrthographicCamera();
        stage = new Stage(new FitViewport(Constants.HEIGHT_H, Constants.WIDTH_H, camera));
        textures = new Array<Texture>();
        for (int i = 1; i <= 2; i++) {
            textures.add(game.getManager().get("img/bg.png", Texture.class));
            textures.get(textures.size - 1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }

        parallaxBackground = new ParallaxBackground(textures, Constants.HEIGHT_H, Constants.WIDTH_H);
        parallaxBackground.setSize(Constants.HEIGHT_H, Constants.WIDTH_H);
        parallaxBackground.setSpeed(1);
        stage.addActor(parallaxBackground);
        this.judul = kode;
        shapeRenderer = new ShapeRenderer();
        spriteBatch = new SpriteBatch();
        piano = new Piano(judul,game);
        glyphLayout = new GlyphLayout();
        font = Constants.font_style(80);

        texture = new Texture("iniciar.png");
        bintang1 = game.getManager().get("img/b1.png", Texture.class);
        bintang2 = game.getManager().get("img/b2.png", Texture.class);
        bintang3 = game.getManager().get("img/b3.png", Texture.class);

        shapeRenderer.setAutoShapeType(true);
        rows = new Array<Row>();
        random = new Random();
        initGame();
        layer1 = new Image(game.getManager().get("img/tiles.png", Texture.class));
        layer2 = new Image(game.getManager().get("img/tiles.png", Texture.class));
        layer3 = new Image(game.getManager().get("img/tiles.png", Texture.class));
        layer4 = new Image(game.getManager().get("img/tiles.png", Texture.class));
        layer1.setPosition(10 ,  0);

        layer2.setPosition(210,  0);
        layer3.setPosition(410,  0);
        layer4.setPosition(610,  0);

        stage.addActor(layer1);
        stage.addActor(layer2);
        stage.addActor(layer3);
        stage.addActor(layer4);

    }

    private float getWidth(BitmapFont font, String text) {
        glyphLayout.reset();
        glyphLayout.setText(font, text);
        return glyphLayout.width;
    }

    @Override
    public void render(float delta) {
        input();

        update(Gdx.graphics.getDeltaTime());

       Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        // ROWS
        shapeRenderer.begin();
       for (Row row : rows) {
            row.draw(shapeRenderer);
      }
        shapeRenderer.end();

        // GUI
        spriteBatch.begin();

        if (state == 0) spriteBatch.draw(texture, 0, tileHeight/4, screenX, tileHeight/2);
        if (statess == 4&&finals) {
            spriteBatch.draw(bintang3, screenX/2 -500 , screenY/2, 333*3, 333);
            font.draw(spriteBatch, String.valueOf(score), screenX/2 - getWidth(font, String.valueOf(score))/2, screenY/2+100);
        }
        if (statess == 3&&finals) {
            spriteBatch.draw(bintang2, screenX/2 -500 , screenY/2, 333*3, 333);
            font.draw(spriteBatch, String.valueOf(score), screenX/2 - getWidth(font, String.valueOf(score))/2, screenY/2+100);

        }
        if (statess == 1&&finals) {
            spriteBatch.draw(bintang1, screenX/2 -500 , screenY/2, 333*3, 333);
            font.draw(spriteBatch, String.valueOf(score), screenX/2 - getWidth(font, String.valueOf(score))/2, screenY/2+100);

        }

        font.draw(spriteBatch, String.valueOf(score), 10, screenY-10);

        fontVel = Musics.judul(judul);

        font.draw(spriteBatch, fontVel , screenX - getWidth(font, fontVel)-10, screenY-10);

        spriteBatch.end();

    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    private void input() {
        if (Gdx.input.justTouched()) {
            // Init a game...
            if(test){
                if (state == 0) {
                    state = 1;
                }
            }else{
                test=true;
            }
            if (state == 1 || state == 3 ||state == 4) {
                finals=false;
                int x = Gdx.input.getX();
                int y = screenX - Gdx.input.getY();
                Gdx.app.log("Tag", "Debug Down h" + " " +y);
                for (int i = 0; i < rows.size; i++) {
                    int returnValue = rows.get(i).touch(x, y);
                    if (returnValue != 0) {
                        if (returnValue == 1 && i == indexInfTiles) {
                            score++;
                            indexInfTiles++;
                            piano.play();
                            if(piano.getindex()==0) {
                                if (statess == 1) {
                                    statess = 3;
                                } else if (statess == 3) {
                                    statess = 4;
                                }
                            }
                        } else if (returnValue == 1) {
                            rows.get(indexInfTiles).error();
                            finish(0);
                        } else {
                            finish(0);
                        }
                        break;
                    }
                }
            }  else if (state == 2) {
            game.setScreen(new MusicScreen(game,lagu));            }
        }
    }

    private void finish(int opt) {
        Gdx.input.vibrate(200);
        finals=true;
        if(score>nilai.load(judul)){
            nilai.save(judul,score);
            nilai.flush();
        }
        state = 2;
        if (opt == 1) {
            for (Row row: rows) {
                row.y += tileHeight;
            }
        }
    }

    private void update(float deltaTime) {
        if (state == 1){
            if(statess == 3){
                totalTime = deltaTime+5;
            }else if(statess == 4){
                totalTime = deltaTime+8;
            }else{
                totalTime = deltaTime+2;
            }
            currentVel = initialVel + tileHeight * totalTime / 8;
            Gdx.app.log("Tag", "Debug Down" +deltaTime + " " +statess);
            for (int i = 0; i < rows.size; i++) {
                int value = rows.get(i).update(deltaTime);
                rows.get(i).anim(deltaTime);
                if (value != 0) {
                    if (value == 1) {
                        rows.removeIndex(i);
                        i--;
                        indexInfTiles --;

                        addRow();
                    } else if (value == 2){
                        finish(1);
                    }
                }
            }
        } else if (state == 2) {
            for (Row row: rows) {
                row.anim(deltaTime);
            }
        }
    }

    private void addRow() {
        float y = rows.get(rows.size - 1).y + tileHeight;
        rows.add(new Row(y, random.nextInt(4)));
    }

    private void initGame() {
        totalTime = 0;
        indexInfTiles = 0;
        score = 0;
        state = 0;

        rows.clear();
        rows.add(new Row(tileHeight, random.nextInt(4)));

        addRow();
        addRow();
        addRow();
        addRow();

        piano.reset();
    }

    @Override
    public void dispose () {
        shapeRenderer.dispose();
        spriteBatch.dispose();
        texture.dispose();
        piano.dispose();
    }

}
