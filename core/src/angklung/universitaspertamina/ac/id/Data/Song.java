package angklung.universitaspertamina.ac.id.Data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import angklung.universitaspertamina.ac.id.MainGame;

public class Song {
    MainGame game;
    private Sound music[]=new Sound[87];
    private Music bg;

    public Song(MainGame game) {
        this.game=game;
        init();
    }
    public void init(){
        music[1]  = game.getManager().get("song/c1.ogg");
        music[2]  = game.getManager().get("song/c2.ogg");
        music[3]  = game.getManager().get("song/c3.ogg");
        music[4]  = game.getManager().get("song/c4.ogg");
        music[5]  = game.getManager().get("song/c5.ogg");
        music[6]  = game.getManager().get("song/c6.ogg");
        music[7]  = game.getManager().get("song/c7.ogg");
        music[8]  = game.getManager().get("song/c8.ogg");
        music[9]  = game.getManager().get("song/c9.ogg");
        music[10]  = game.getManager().get("song/c10.ogg");
        music[11]  = game.getManager().get("song/c11.ogg");
        music[12]  = game.getManager().get("song/c12.ogg");
        music[13]  = game.getManager().get("song/c13.ogg");
        music[14]  = game.getManager().get("song/c14.ogg");
        music[15]  = game.getManager().get("song/c15.ogg");
        music[16]  = game.getManager().get("song/c16.ogg");
        music[17]  = game.getManager().get("song/c17.ogg");
        music[18]  = game.getManager().get("song/c18.ogg");
        music[19]  = game.getManager().get("song/c19.ogg");
        music[20]  = game.getManager().get("song/c20.ogg");
        music[21]  = game.getManager().get("song/c21.ogg");
        music[22]  = game.getManager().get("song/c22.ogg");
        music[23]  = game.getManager().get("song/c23.ogg");
        music[24]  = game.getManager().get("song/c24.ogg");
        music[25]  = game.getManager().get("song/c25.ogg");
        music[26]  = game.getManager().get("song/c26.ogg");
        music[27]  = game.getManager().get("song/c27.ogg");
        music[28]  = game.getManager().get("song/c28.ogg");
        music[29]  = game.getManager().get("song/c29.ogg");
        music[30]  = game.getManager().get("song/c30.ogg");
        music[33]  = game.getManager().get("song/cb.ogg");
        music[31]  = game.getManager().get("song/cba.ogg");
        music[32]  = game.getManager().get("song/cba_.ogg");
        music[34]  = game.getManager().get("song/cbc.ogg");
        music[35]  = game.getManager().get("song/cbc_.ogg");
        music[36]  = game.getManager().get("song/cbd.ogg");
        music[37]  = game.getManager().get("song/cbd_.ogg");
        music[38]  = game.getManager().get("song/cbe.ogg");
        music[39]  = game.getManager().get("song/cbf.ogg");
        music[0]  = game.getManager().get("song/cbf_.ogg");
        music[40]  = game.getManager().get("song/cbg.ogg");
        music[41]  = game.getManager().get("song/cbg_.ogg");
        music[74]  = game.getManager().get("song/bass_a.ogg");
        music[75]  = game.getManager().get("song/bass_a_.ogg");
        music[76]  = game.getManager().get("song/bass_b.ogg");
        music[77]  = game.getManager().get("song/bass_c.ogg");
        music[78]  = game.getManager().get("song/bass_c_.ogg");
        music[79]  = game.getManager().get("song/bass_d.ogg");
        music[80]  = game.getManager().get("song/bass_d_.ogg");
        music[81]  = game.getManager().get("song/bass_e.ogg");
        music[82]  = game.getManager().get("song/bass_f.ogg");
        music[42]  = game.getManager().get("song/bass_f_.ogg");
        music[83]  = game.getManager().get("song/bass_g.ogg");
        music[84]  = game.getManager().get("song/bass_g.ogg");
        music[43]  = game.getManager().get("song/m1g.ogg");
        music[44]  = game.getManager().get("song/m2g.ogg");
        music[45]  = game.getManager().get("song/m3a.ogg");
        music[46]  = game.getManager().get("song/m4a.ogg");
        music[47]  = game.getManager().get("song/m4a.ogg");
        music[48]  = game.getManager().get("song/m5b.ogg");
        music[49]  = game.getManager().get("song/m6c.ogg");
        music[50]  = game.getManager().get("song/m7c.ogg");
        music[51]  = game.getManager().get("song/m8d.ogg");
        music[52]  = game.getManager().get("song/m9d.ogg");
        music[53]  = game.getManager().get("song/m10e.ogg");
        music[54]  = game.getManager().get("song/m11f.ogg");
        music[55]  = game.getManager().get("song/m12f.ogg");
        music[56]  = game.getManager().get("song/m13g.ogg");
        music[57]  = game.getManager().get("song/m14g.ogg");
        music[58]  = game.getManager().get("song/m15a.ogg");
        music[59]  = game.getManager().get("song/m16a.ogg");
        music[60]  = game.getManager().get("song/m17b.ogg");
        music[61]  = game.getManager().get("song/m18c.ogg");
        music[62]  = game.getManager().get("song/m19c.ogg");
        music[63]  = game.getManager().get("song/m20d.ogg");
        music[64]  = game.getManager().get("song/m21d.ogg");
        music[65]  = game.getManager().get("song/m22e.ogg");
        music[66]  = game.getManager().get("song/m23f.ogg");
        music[67]  = game.getManager().get("song/m24f.ogg");
        music[68]  = game.getManager().get("song/m25g.ogg");
        music[69]  = game.getManager().get("song/m26g.ogg");
        music[70]  = game.getManager().get("song/m27a.ogg");
        music[71]  = game.getManager().get("song/m28a.ogg");
        music[72]  = game.getManager().get("song/m29b.ogg");
        music[73]  = game.getManager().get("song/m30c.ogg");
    }
    public void play(int kode){
        music[kode].play();
    }
    public void stop(int kode){

        music[kode].stop();
    }

    public void play_bg(){
        bg  = game.getManager().get("bg.ogg");
        bg.setLooping(true);
        bg.play();
    }
    public void stop_bg(){
        bg.stop();
    }
    public void pause_bg(){
        bg.pause();
    }
}
