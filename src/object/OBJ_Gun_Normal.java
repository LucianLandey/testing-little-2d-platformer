package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_Gun_Normal extends Entity {
    public OBJ_Gun_Normal(GamePanel gp){
        super(gp);
        name = "Normal Gun";
        down1 = setup("/objects/normalgun");
        attack = 1;
    }
}
