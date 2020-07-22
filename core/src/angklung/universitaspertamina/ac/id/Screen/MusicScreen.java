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
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

import angklung.universitaspertamina.ac.id.Constants;
import angklung.universitaspertamina.ac.id.Data.Song;
import angklung.universitaspertamina.ac.id.MainGame;
import angklung.universitaspertamina.ac.id.ParallaxBackground;

public class MusicScreen extends BaseScreen{
    private Stage stage;
    private Song lagu;
    private int size_x_1=20,size_x_2=20,size_x_3=20,size_x_4=20,size_x_5=20,size_x_6=20;
    private int pick[] = new int[3];
    private Image map,list;
    private TextButton button[]= new TextButton[6];
    private TextButton pic_map[]= new TextButton[9],exit;
    private TextButton.TextButtonStyle textButtonStyle;
    private TextButton.TextButtonStyle textButtonStyle2,textButtonStyle3;
    private Array<Texture> textures;
    private ParallaxBackground parallaxBackground;
    private  Label.LabelStyle labelStyle;
    private int pilih=4;

    public MusicScreen(final MainGame game, Song lagus) {
        super(game);
        if(game.tipe) {
            game.handler.setOrientationLandscape();
        }
        this.lagu=lagus;
        lagu.play_bg();
        stage = new Stage(new FitViewport(Constants.WIDTH_H, Constants.HEIGHT_H));
        textButtonStyle2 = new TextButton.TextButtonStyle();
        textButtonStyle2.font = Constants.font_style(24);
        textButtonStyle2.down=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/pin_h.png", Texture.class)));
        textButtonStyle2.up= new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/pin.png", Texture.class)));

        textButtonStyle3 = new TextButton.TextButtonStyle();
        textButtonStyle3.font = Constants.font_style(24);
        textButtonStyle3.down=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/exit_h.png", Texture.class)));
        textButtonStyle3.up= new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/exit.png", Texture.class)));

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Constants.font_style(24);
        textButtonStyle.down=new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/h_menu_song.png", Texture.class)));
        textButtonStyle.up= new TextureRegionDrawable(new TextureRegion(game.getManager().get("img/menu_song.png", Texture.class)));
        textures = new Array<Texture>();
        for(int i = 1; i <=2;i++){
            textures.add(game.getManager().get("img/bg2.png", Texture.class));
            textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }
        map = new Image(game.getManager().get("img/map.png", Texture.class));
        map.setPosition(80,200);

        parallaxBackground = new ParallaxBackground(textures, Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSize(Constants.WIDTH_H,Constants.HEIGHT_H);
        parallaxBackground.setSpeed(1);
        pic_map[0] = new TextButton("", textButtonStyle2);
        pic_map[0].setSize(30, 30);
        pic_map[0].setPosition(Constants.WIDTH_H/2-150,  260);
        pic_map[1] = new TextButton("", textButtonStyle2);
        pic_map[1].setSize(30, 30);
        pic_map[1].setPosition(Constants.WIDTH_H/2-220,  270);
        pic_map[2] = new TextButton("", textButtonStyle2);
        pic_map[2].setSize(30, 30);
        pic_map[2].setPosition(Constants.WIDTH_H/2-290,  280);
        pic_map[3] = new TextButton("", textButtonStyle2);
        pic_map[3].setSize(30, 30);
        pic_map[3].setPosition(Constants.WIDTH_H/2 +50,  400);
        pic_map[4] = new TextButton("", textButtonStyle2);
        pic_map[4].setSize(30, 30);
        pic_map[4].setPosition(Constants.WIDTH_H/2 +230,  450);
        pic_map[5] = new TextButton("", textButtonStyle2);
        pic_map[5].setSize(30, 30);
        pic_map[5].setPosition(Constants.WIDTH_H/2-150,  420);
        pic_map[6] = new TextButton("", textButtonStyle2);
        pic_map[6].setSize(30, 30);
        pic_map[6].setPosition(Constants.WIDTH_H/2+100,  410);
        pic_map[7] = new TextButton("", textButtonStyle2);
        pic_map[7].setSize(30, 30);
        pic_map[7].setPosition(Constants.WIDTH_H/2-440,  480);
        pic_map[8] = new TextButton("", textButtonStyle2);
        pic_map[8].setSize(30, 30);
        pic_map[8].setPosition(Constants.WIDTH_H/2-400,  400);
        button[4] = new TextButton("Back", textButtonStyle);
        button[4].setSize(125, 60);
        button[4].setPosition(button[4].getWidth() / 2,  50);
        exit = new TextButton("", textButtonStyle3);
        exit.setSize(60, 60);

        button[4].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                game.setScreen(new MenuScreen(game));
                return true;
            }
        });
        pic_map[0].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Tag", "Debug Down");
                pilih=0;
                return true;
            }
        });
        pic_map[1].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pilih=1;
                return true;
            }
        });
        pic_map[2].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pilih=2;
                return true;
            }
        });
        pic_map[3].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pilih=3;
                return true;
            }
        });
        pic_map[4].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pilih=3;
                return true;
            }
        });
        pic_map[5].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pilih=3;
                return true;
            }
        });
        pic_map[6].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pilih=3;
                return true;
            }
        });
        pic_map[7].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pilih=3;
                return true;
            }
        });
        pic_map[8].addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pilih=3;
                return true;
            }
        });
        exit.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pilih=4;
                return true;
            }
        });
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
        switch (pilih){
            case 0:
                list = new Image(game.getManager().get("img/m_jawatimur.png", Texture.class));
                list.setPosition(Constants.WIDTH_H-50 - list.getWidth(),Constants.HEIGHT_H-50- list.getHeight());
                exit.setPosition(Constants.WIDTH_H-50 - list.getWidth() -exit.getWidth()/2,Constants.HEIGHT_H-30 -exit.getHeight());
                button[0] = new TextButton("Lir Ilir", textButtonStyle);
                button[0].setSize(300, 60);
                button[0].setPosition(Constants.WIDTH_H-50 - list.getWidth() + 15,Constants.HEIGHT_H-210);
                button[1] = new TextButton("Jaranan", textButtonStyle);
                button[1].setSize(300, 60);
                button[1].setPosition(Constants.WIDTH_H-50 - list.getWidth() + 15,Constants.HEIGHT_H-290);
                button[0].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        lagu.stop_bg();
                        game.setScreen(new TilesScreen(game,7,lagu));
                        return true;
                    }
                });
                button[1].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        lagu.stop_bg();
                        game.setScreen(new TilesScreen(game,8,lagu));
                        return true;
                    }
                });
                stage.clear();
                stage.addActor(parallaxBackground);
                stage.addActor(map);
                stage.addActor(pic_map[0]);
                stage.addActor(pic_map[1]);
                stage.addActor(pic_map[2]);
                stage.addActor(pic_map[3]);
                stage.addActor(pic_map[4]);
                stage.addActor(pic_map[5]);
                stage.addActor(pic_map[6]);
                stage.addActor(pic_map[7]);
                stage.addActor(pic_map[8]);
                stage.addActor( button[4]);
                stage.addActor(list);
                stage.addActor(exit);
                stage.addActor( button[0]);
                stage.addActor( button[1]);
                break;
            case 1:
                list = new Image(game.getManager().get("img/m_jawatengah.png", Texture.class));
                list.setPosition(Constants.WIDTH_H-50 - list.getWidth(),Constants.HEIGHT_H-50- list.getHeight());
                exit.setPosition(Constants.WIDTH_H-50 - list.getWidth() -exit.getWidth()/2,Constants.HEIGHT_H-30 -exit.getHeight());
                button[0] = new TextButton("Gundul Gundul Pacul", textButtonStyle);
                button[0].setSize(300, 60);
                button[0].setPosition(Constants.WIDTH_H-50 - list.getWidth() + 15,Constants.HEIGHT_H-210);
                button[1] = new TextButton("Cublak Cublak Suweng", textButtonStyle);
                button[1].setSize(300, 60);
                button[1].setPosition(Constants.WIDTH_H-50 - list.getWidth() + 15,Constants.HEIGHT_H-290);
                button[2] = new TextButton("Te Kate Dipanah", textButtonStyle);
                button[2].setSize(300, 60);
                button[2].setPosition(Constants.WIDTH_H-50 - list.getWidth() + 15,Constants.HEIGHT_H-370);
                button[0].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        lagu.stop_bg();
                        game.setScreen(new TilesScreen(game,4,lagu));
                        return true;
                    }
                });
                button[1].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        lagu.stop_bg();
                        game.setScreen(new TilesScreen(game,5,lagu));
                        return true;
                    }
                });
                button[2].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        lagu.stop_bg();
                        game.setScreen(new TilesScreen(game,6,lagu));
                        return true;
                    }
                });
                stage.clear();
                stage.addActor(parallaxBackground);
                stage.addActor(map);
                stage.addActor(pic_map[0]);
                stage.addActor(pic_map[1]);
                stage.addActor(pic_map[2]);
                stage.addActor(pic_map[3]);
                stage.addActor(pic_map[4]);
                stage.addActor(pic_map[5]);
                stage.addActor(pic_map[6]);
                stage.addActor(pic_map[7]);
                stage.addActor(pic_map[8]);
                stage.addActor( button[4]);
                stage.addActor(list);
                stage.addActor(exit);
                stage.addActor( button[0]);
                stage.addActor( button[1]);
                stage.addActor( button[2]);
                break;
            case 2:
                list = new Image(game.getManager().get("img/m_jawabarat.png", Texture.class));
                list.setPosition(Constants.WIDTH_H-50 - list.getWidth(),Constants.HEIGHT_H-50- list.getHeight());
                exit.setPosition(Constants.WIDTH_H-50 - list.getWidth() -exit.getWidth()/2,Constants.HEIGHT_H-30 -exit.getHeight());
                button[0] = new TextButton("Manuk Dadali", textButtonStyle);
                button[0].setSize(300, 60);
                button[0].setPosition(Constants.WIDTH_H-50 - list.getWidth() + 15,Constants.HEIGHT_H-210);
                button[1] = new TextButton("Es Lilin", textButtonStyle);
                button[1].setSize(300, 60);
                button[1].setPosition(Constants.WIDTH_H-50 - list.getWidth() + 15,Constants.HEIGHT_H-290);
                button[2] = new TextButton("Tokeceng", textButtonStyle);
                button[2].setSize(300, 60);
                button[2].setPosition(Constants.WIDTH_H-50 - list.getWidth() + 15,Constants.HEIGHT_H-370);
                button[3] = new TextButton("Cing Cangkeling", textButtonStyle);
                button[3].setSize(300, 60);
                button[3].setPosition(Constants.WIDTH_H-50 - list.getWidth() + 15,Constants.HEIGHT_H-450);
                button[0].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        lagu.stop_bg();
                        game.setScreen(new TilesScreen(game,0,lagu));
                        return true;
                    }
                });
                button[1].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        lagu.stop_bg();
                        game.setScreen(new TilesScreen(game,1,lagu));
                        return true;
                    }
                });
                button[2].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        lagu.stop_bg();
                        game.setScreen(new TilesScreen(game,2,lagu));
                        return true;
                    }
                });
                button[3].addListener(new InputListener() {
                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        lagu.stop_bg();
                        game.setScreen(new TilesScreen(game,3,lagu));
                        return true;
                    }
                });
                stage.clear();
                stage.addActor(parallaxBackground);
                stage.addActor(map);
                stage.addActor(pic_map[0]);
                stage.addActor(pic_map[1]);
                stage.addActor(pic_map[2]);
                stage.addActor(pic_map[3]);
                stage.addActor(pic_map[4]);
                stage.addActor(pic_map[5]);
                stage.addActor(pic_map[6]);
                stage.addActor(pic_map[7]);
                stage.addActor(pic_map[8]);
                stage.addActor( button[4]);
                stage.addActor(list);
                stage.addActor(exit);
                stage.addActor( button[0]);
                stage.addActor( button[1]);
                stage.addActor( button[2]);
                stage.addActor( button[3]);
                break;
            case 3:
                list = new Image(game.getManager().get("img/lock.png", Texture.class));
                list.setPosition(Constants.WIDTH_H-50 - list.getWidth(),Constants.HEIGHT_H-50- list.getHeight());
                exit.setPosition(Constants.WIDTH_H-50 - list.getWidth() -exit.getWidth()/2,Constants.HEIGHT_H-30 -exit.getHeight());
                stage.clear();
                stage.addActor(parallaxBackground);
                stage.addActor(map);
                stage.addActor(pic_map[0]);
                stage.addActor(pic_map[1]);
                stage.addActor(pic_map[2]);
                stage.addActor(pic_map[3]);
                stage.addActor(pic_map[4]);
                stage.addActor(pic_map[5]);
                stage.addActor(pic_map[6]);
                stage.addActor(pic_map[7]);
                stage.addActor(pic_map[8]);
                stage.addActor(button[4]);
                stage.addActor(list);
                stage.addActor(exit);
                break;
            case 4:
                stage.clear();
                stage.addActor(parallaxBackground);
                stage.addActor(map);
                stage.addActor(pic_map[0]);
                stage.addActor(pic_map[1]);
                stage.addActor(pic_map[2]);
                stage.addActor(pic_map[3]);
                stage.addActor(pic_map[4]);
                stage.addActor(pic_map[5]);
                stage.addActor(pic_map[6]);
                stage.addActor(pic_map[7]);
                stage.addActor(pic_map[8]);
                stage.addActor(button[4]);
                break;
        }
        stage.act();
        stage.draw();
    }
}
