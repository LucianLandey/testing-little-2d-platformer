package object;

import Main.GamePanel;
import entity.Projectile;

public class OBJ_bullet extends Projectile {

    GamePanel gp;

    public OBJ_bullet(GamePanel gp) {
        super(gp);
        this.gp = gp;


        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 2;
    }
}
