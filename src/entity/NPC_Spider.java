package entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

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
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/spiderright2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/spiderleft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/spiderleft2.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/spiderup1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/spiderup2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/spiderdown1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/spiderdown2.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
