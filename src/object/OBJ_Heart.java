package object;

import Main.GamePanel;
import entity.Entity;

public class OBJ_Heart extends Entity {

    public OBJ_Heart(GamePanel gp) {
        super(gp);
        name = "Heart";
        image1 = setup("/objects/heart");
        image2 = setup("/objects/halfheart");
        image3 = setup("/objects/noheart");

    }
}
