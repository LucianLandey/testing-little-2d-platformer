package object;

import Main.GamePanel;
import entity.Entity;
import entity.Projectile;


public class OBJ_bullet extends Entity {

    GamePanel gp;

    public OBJ_bullet(GamePanel gp) {
        super(gp);
        this.gp = gp;


        speed = 5;
        maxLife = 80;
        life = maxLife;
        //attack = 2;
        alive = false;
        getImage();
    }
    public void getImage(){
        right1 = setup("/projectile/bullet1");
        right2 = setup("/projectile/bullet2");
        left1 = setup("/projectile/bullet1");
        left2 = setup("/projectile/bullet2");
//        right1 = setup("/player/mushroomwalkright1");
//        right1 = setup("/player/mushroomwalkright1");
//        right1 = setup("/player/mushroomwalkright1");
//        right1 = setup("/player/mushroomwalkright1");


    }
}
