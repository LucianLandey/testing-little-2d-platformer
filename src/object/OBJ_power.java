package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_power extends Entity {

    public OBJ_power(GamePanel gp) {
        super(gp);
        name = "power";
        down1 = setup("/objects/powerup1");


    }

}
