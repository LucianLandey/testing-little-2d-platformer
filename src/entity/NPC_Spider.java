package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Spider extends Entity{

    public NPC_Spider(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
    }
    public void getImage() {
        try {
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/spiderright1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/spiderright2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/spiderleft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/spiderleft2.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/spiderup1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/spiderup2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/spiderdown1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("npc/spiderdown2.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
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
