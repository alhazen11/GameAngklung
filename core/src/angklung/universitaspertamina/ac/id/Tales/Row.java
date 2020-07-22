package angklung.universitaspertamina.ac.id.Tales;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import static angklung.universitaspertamina.ac.id.Tales.Cons.correct;
import static angklung.universitaspertamina.ac.id.Tales.Cons.currentVel;
import static angklung.universitaspertamina.ac.id.Tales.Cons.screenX;
import static angklung.universitaspertamina.ac.id.Tales.Cons.tileHeight;
import static angklung.universitaspertamina.ac.id.Tales.Cons.tileWidth;
import static angklung.universitaspertamina.ac.id.Tales.Cons.verde;
import static angklung.universitaspertamina.ac.id.Tales.Cons.wrong;

/**
 * Created by josevieira on 11/11/17.
 */
public class Row {

    public float y;

    private int correctTile;  //0..3

    private int pos;

    private boolean ok;

    private boolean destroyed;

    private float anim;

    public Row(float y, int correctTile) {
        this.y = y;
        this.correctTile = correctTile;
        this.ok = false;

        destroyed = false;
        anim = 0;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(verde);
        shapeRenderer.rect(correctTile*tileWidth, y, tileWidth, tileHeight);

        if (destroyed) {
            if (ok) {
                shapeRenderer.setColor(correct);
            } else {
                shapeRenderer.setColor(wrong);
            }
            shapeRenderer.rect(pos * tileWidth + (tileWidth - anim * tileWidth)/2f,
                    y + (tileHeight - anim * tileHeight)/2f,
                    anim * tileWidth, anim * tileHeight);
        }

        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.GRAY);

        for (int i = 0; i <= 3; i++) {
            shapeRenderer.rect(i * tileWidth, y, tileWidth, tileHeight);
        }
    }

    public void anim(float deltaTime) {
        if (destroyed && anim < 1) {
            anim += 5 * deltaTime;
            if (anim >= 1) {
                anim = 1;
            }
        }
    }

    public int update(float deltaTime) {
        y -= deltaTime * currentVel;

        if (y < 0 - tileHeight) {
            if (ok) {
                return 1;
            } else {
                error();
                return 2;
            }
        }

        return 0;
    }

    public int touch(int tx, int ty) {

        if (ty >= y && ty <= y + tileWidth) {
            Gdx.app.log("Tag", "hancur " +y);
            pos = tx / (tileHeight);
            Gdx.app.log("Tag", "hancur " + y + " "+tileWidth);
            Gdx.app.log("Tag", "hancur " + ty);
            if (pos == correctTile) {
                this.ok = true;
                destroyed = true;
                return 1;
            } else {
                this.ok = false;
                destroyed = true;
                return 2;
            }
        }
        return 0;
    }

    public void error() {
        destroyed = true;
        pos = correctTile;
    }

}
