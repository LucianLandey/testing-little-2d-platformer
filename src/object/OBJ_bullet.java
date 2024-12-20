package object;

import Main.GamePanel;
import entity.Entity;
import entity.Projectile;


public class OBJ_bullet extends Projectile {

    GamePanel gp;

    public OBJ_bullet(GamePanel gp) {
        super(gp);
        this.gp = gp;

        name = "Bullet";
        speed = 15;
        maxLife = 10;
        life = maxLife;
        //attack = 2;
        alive = false;
        getImage();
    }
    public void getImage(){
        right1 = setup("/projectiles/bullet1");
        right2 = setup("/projectiles/bullet2");
        left1 = setup("/projectiles/bullet1");
        left2 = setup("/projectiles/bullet2");
        down1 = setup("/projectiles/bullet1");
        down2 = setup("/projectiles/bullet2");
        up1 = setup("/projectiles/bullet1");
        up2 = setup("/projectiles/bullet2");


    }
}
