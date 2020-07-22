package angklung.universitaspertamina.ac.id.Data;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Score {
    private Preferences prefs = Gdx.app.getPreferences("My Preferences");
    public void save(int kode,int score){
        switch (kode){
            case 0:
                prefs.putInteger("lagu0", score);
                break;
            case 1:
                prefs.putInteger("lagu1", score);
                break;
            case 2:
                prefs.putInteger("lagu2", score);
                break;
            case 3:
                prefs.putInteger("lagu3", score);
                break;
            case 4:
                prefs.putInteger("lagu4", score);
                break;
            case 5:
                prefs.putInteger("lagu5", score);
                break;
            case 6:
                prefs.putInteger("lagu6", score);
                break;
            case 7:
                prefs.putInteger("lagu7", score);
                break;
            case 8:
                prefs.putInteger("lagu8", score);
                break;
        }
    }
    public int load(int kode){
        switch (kode){
            case 0:
                return prefs.getInteger("lagu0", 0);
            case 1:
                return prefs.getInteger("lagu1", 0);
            case 2:
                return prefs.getInteger("lagu2", 0);
            case 3:
                return prefs.getInteger("lagu3", 0);
            case 4:
                return prefs.getInteger("lagu4", 0);
            case 5:
                return prefs.getInteger("lagu5", 0);
            case 6:
                return prefs.getInteger("lagu6", 0);
            case 7:
                return prefs.getInteger("lagu7", 0);
            case 8:
                return prefs.getInteger("lagu8", 0);
        }
        return Integer.parseInt(null);
    }
    public void flush(){
        prefs.flush();
    }
}
