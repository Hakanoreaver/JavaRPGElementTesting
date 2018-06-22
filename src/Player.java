/**
 * Created by Hakanoreaver on 20/6/18.
 */
public class Player extends Sprite {
    int health = 100, mana = 100;


    public Player(int x, int y) {
        super(x,y);
    }

    public void swingSword() {
        SoundEffect.SWORDSWING.play();
    }
}
