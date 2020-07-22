package angklung.universitaspertamina.ac.id.Tales;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

import angklung.universitaspertamina.ac.id.Data.Music;
import angklung.universitaspertamina.ac.id.Data.Song;
import angklung.universitaspertamina.ac.id.MainGame;

/**
 * Created by josevieira on 11/11/17.
 */
public class Piano {


    private int [] lagunya;
    private  Music now;
    private Song bunyi;
    private int index = 0;

    public Piano(int music,MainGame game) {
        bunyi = new Song(game);
        now = new Music();
        lagunya= now.lagu(music);
    }

    public void play() {
        Gdx.app.log("Tag", "Debug Down" +lagunya[index] +lagunya.length);
        if(!(lagunya[index] ==99)) {
            bunyi.play(lagunya[index] + 42);
        }
        index++;
        if (index == lagunya.length) {
            index = 0;
        }
    }
    public int getindex(){
        return index;
    }

    public void reset() {
        index = 0;
    }

    public void dispose() {

    }

}
