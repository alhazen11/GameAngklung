package angklung.universitaspertamina.ac.id;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import angklung.universitaspertamina.ac.id.Screen.BaseScreen;
import angklung.universitaspertamina.ac.id.Screen.LoadingScreen;
import angklung.universitaspertamina.ac.id.Screen.MenuScreen;


public class MainGame extends Game {

    private AssetManager manager;
    public BaseScreen loadingScreen, menuScreen;
    public static CustomHandler handler;
    public boolean tipe=true;
    public MainGame(){
        tipe=false;
    }
    public MainGame(CustomHandler handler){
        this.handler = handler;
    }
    @Override
    public void create() {
        if(tipe){
            handler.setOrientationLandscape();
        }
        manager = new AssetManager();
        manager.load("song/c1.ogg", Sound.class);
        manager.load("song/c2.ogg", Sound.class);
        manager.load("song/c3.ogg", Sound.class);
        manager.load("song/c4.ogg", Sound.class);
        manager.load("song/c5.ogg", Sound.class);
        manager.load("song/c6.ogg", Sound.class);
        manager.load("song/c7.ogg", Sound.class);
        manager.load("song/c8.ogg", Sound.class);
        manager.load("song/c9.ogg", Sound.class);
        manager.load("song/c10.ogg", Sound.class);
        manager.load("song/c11.ogg", Sound.class);
        manager.load("song/c12.ogg", Sound.class);
        manager.load("song/c13.ogg", Sound.class);
        manager.load("song/c14.ogg", Sound.class);
        manager.load("song/c15.ogg", Sound.class);
        manager.load("song/c16.ogg", Sound.class);
        manager.load("song/c17.ogg", Sound.class);
        manager.load("song/c18.ogg", Sound.class);
        manager.load("song/c19.ogg", Sound.class);
        manager.load("song/c20.ogg", Sound.class);
        manager.load("song/c21.ogg", Sound.class);
        manager.load("song/c22.ogg", Sound.class);
        manager.load("song/c23.ogg", Sound.class);
        manager.load("song/c24.ogg", Sound.class);
        manager.load("song/c25.ogg", Sound.class);
        manager.load("song/c26.ogg", Sound.class);
        manager.load("song/c27.ogg", Sound.class);
        manager.load("song/c28.ogg", Sound.class);
        manager.load("song/c29.ogg", Sound.class);
        manager.load("song/c30.ogg", Sound.class);
        manager.load("song/cb.ogg", Sound.class);
        manager.load("song/cba.ogg", Sound.class);
        manager.load("song/cba_.ogg", Sound.class);
        manager.load("song/cbc.ogg", Sound.class);
        manager.load("song/cbc_.ogg", Sound.class);
        manager.load("song/cbd.ogg", Sound.class);
        manager.load("song/cbd_.ogg", Sound.class);
        manager.load("song/cbe.ogg", Sound.class);
        manager.load("song/cbf.ogg", Sound.class);
        manager.load("song/cbf_.ogg", Sound.class);
        manager.load("song/cbg.ogg", Sound.class);
        manager.load("song/cbg_.ogg", Sound.class);
        manager.load("song/bass_a.ogg", Sound.class);
        manager.load("song/bass_a_.ogg", Sound.class);
        manager.load("song/bass_b.ogg", Sound.class);
        manager.load("song/bass_c.ogg", Sound.class);
        manager.load("song/bass_c_.ogg", Sound.class);
        manager.load("song/bass_d.ogg", Sound.class);
        manager.load("song/bass_d_.ogg", Sound.class);
        manager.load("song/bass_e.ogg", Sound.class);
        manager.load("song/bass_f.ogg", Sound.class);
        manager.load("song/bass_f_.ogg", Sound.class);
        manager.load("song/bass_g.ogg", Sound.class);
        manager.load("song/bass_g_.ogg", Sound.class);
        manager.load("song/m1g.ogg", Sound.class);
        manager.load("song/m2g.ogg", Sound.class);
        manager.load("song/m3a.ogg", Sound.class);
        manager.load("song/m4a.ogg", Sound.class);
        manager.load("song/m4a.ogg", Sound.class);
        manager.load("song/m5b.ogg", Sound.class);
        manager.load("song/m6c.ogg", Sound.class);
        manager.load("song/m7c.ogg", Sound.class);
        manager.load("song/m8d.ogg", Sound.class);
        manager.load("song/m9d.ogg", Sound.class);
        manager.load("song/m10e.ogg", Sound.class);
        manager.load("song/m11f.ogg", Sound.class);
        manager.load("song/m12f.ogg", Sound.class);
        manager.load("song/m13g.ogg", Sound.class);
        manager.load("song/m14g.ogg", Sound.class);
        manager.load("song/m15a.ogg", Sound.class);
        manager.load("song/m16a.ogg", Sound.class);
        manager.load("song/m17b.ogg", Sound.class);
        manager.load("song/m18c.ogg", Sound.class);
        manager.load("song/m19c.ogg", Sound.class);
        manager.load("song/m20d.ogg", Sound.class);
        manager.load("song/m21d.ogg", Sound.class);
        manager.load("song/m22e.ogg", Sound.class);
        manager.load("song/m23f.ogg", Sound.class);
        manager.load("song/m24f.ogg", Sound.class);
        manager.load("song/m25g.ogg", Sound.class);
        manager.load("song/m26g.ogg", Sound.class);
        manager.load("song/m27a.ogg", Sound.class);
        manager.load("song/m28a.ogg", Sound.class);
        manager.load("song/m29b.ogg", Sound.class);
        manager.load("song/m30c.ogg", Sound.class);
        manager.load("bg.ogg", Music.class);
        manager.load("img/b2.png", Texture.class);
        manager.load("img/b1.png", Texture.class);
        manager.load("img/bg.png", Texture.class);
        manager.load("img/bg2.png", Texture.class);
        manager.load("img/exit.png", Texture.class);
        manager.load("img/exit_h.png", Texture.class);
        manager.load("img/pin.png", Texture.class);
        manager.load("img/pin_h.png", Texture.class);
        manager.load("img/h_menu.png", Texture.class);
        manager.load("img/h_menu_song.png", Texture.class);
        manager.load("img/highscore.png", Texture.class);
        manager.load("img/m_jawabarat.png", Texture.class);
        manager.load("img/m_jawatimur.png", Texture.class);
        manager.load("img/m_jawatengah.png", Texture.class);
        manager.load("img/map.png", Texture.class);
        manager.load("img/map_new.png", Texture.class);
        manager.load("img/menu.png", Texture.class);
        manager.load("img/menu_song.png", Texture.class);
        manager.load("img/nada.png", Texture.class);
        manager.load("img/nada_h.png", Texture.class);
        manager.load("img/logo.png", Texture.class);
        manager.load("img/b3.png", Texture.class);
        manager.load("img/tiles.png", Texture.class);
        manager.load("img/angkung.png", Texture.class);
        manager.load("img/music_mute.png", Texture.class);
        manager.load("img/music_on.png", Texture.class);
        manager.load("img/v_off.png", Texture.class);
        manager.load("img/v_on.png", Texture.class);
        manager.load("img/lock.png", Texture.class);
        manager.load("img/tuts_w.png", Texture.class);
        manager.load("img/tuts_w_d.png", Texture.class);
        manager.load("img/tuts_b_d.png", Texture.class);
        manager.load("img/tuts_b.png", Texture.class);

        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
    }

    public void finishLoading() {
        menuScreen = new MenuScreen(this);
        setScreen(menuScreen);
    }

    public AssetManager getManager() {
        return manager;
    }

}