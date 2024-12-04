package entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_Spider extends Entity{

    public NPC_Spider(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
    }
    public void getImage() {
        right1 = setup("/npc/spiderright1");
        right2 = setup("/npc/spiderright2");
        left1 = setup("/npc/spiderleft1");
        left2 = setup("/npc/spiderleft2");
        up1 = setup("/npc/spiderup1");
        up2 = setup("/npc/spiderup2");
        down1 = setup("/npc/spiderdown1");
        down2 = setup("/npc/spiderdown2");

    }
    public void setAction() {
        Random random = new Random();
        int i = random.nextInt(100)+1; //pick num from 1-100
        if (i <= 25) {
            direction = "up";
        }
        if (i > 25 && i <= 50) {
            direction = "down";
        }
        if (i > 50 && i <= 75) {
            direction = "left";
        }
        if (i >75 && i <= 100) {
            direction = "right";
        }
    }
}
