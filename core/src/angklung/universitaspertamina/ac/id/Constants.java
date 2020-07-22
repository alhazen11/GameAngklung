package angklung.universitaspertamina.ac.id;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Constants {
    public static final float WIDTH_H = 1300;
    public static final float HEIGHT_H = 800;
    public static BitmapFont font_style(int size){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        BitmapFont font12 = generator.generateFont(parameter);
        generator.dispose();
        return font12;
    }
    public static String node(int no)
    {
        String judul = null;
        switch (no) {
            case 0: judul="Bass F#"; break;
            case 1: judul="G"; break;
            case 2: judul="G#"; break;
            case 3: judul="A"; break;
            case 4: judul="A#"; break;
            case 5: judul="B"; break;
            case 6: judul="C'"; break;
            case 7: judul="C'#"; break;
            case 8: judul="D'"; break;
            case 9: judul="D'#"; break;
            case 10: judul="E'"; break;
            case 11: judul="F'"; break;
            case 12: judul="F#"; break;
            case 13: judul="G'"; break;
            case 14: judul="G'#"; break;
            case 15: judul="A'"; break;
            case 16: judul="A'#"; break;
            case 17: judul="B'"; break;
            case 18: judul="C''"; break;
            case 19: judul="C''#"; break;
            case 20: judul="D''"; break;
            case 21: judul="D''#"; break;
            case 22: judul="E''"; break;
            case 23: judul="F''"; break;
            case 24: judul="F''#"; break;
            case 25: judul="G''"; break;
            case 26: judul="G''#"; break;
            case 27: judul="A''"; break;
            case 28: judul="A''#"; break;
            case 29: judul="B''"; break;
            case 30: judul="C'''"; break;
            case 31: judul="Bass A"; break;
            case 32: judul="Bass A#"; break;
            case 33: judul="Bass B"; break;
            case 34: judul="Bass C"; break;
            case 35: judul="Bass C#"; break;
            case 36: judul="Bass D"; break;
            case 37: judul="Bass D#"; break;
            case 38: judul="Bass E"; break;
            case 39: judul="Bass F"; break;
            case 40: judul="Bass G"; break;
            case 41: judul="Bass G#"; break;
        }

        return judul;
    }
}
