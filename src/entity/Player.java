package entity;


import Main.GamePanel;
import Main.KeyHandler;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class Player extends Entity{


    GamePanel gp;
    KeyHandler keyH;


    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        x=100;
        y= 100;
        speed=4;
        direction = "right";

    }
    public void getPlayerImage() {
        try {
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkright1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkright2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkleft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkleft2.png"));

        }catch(IOException e) {
            e.printStackTrace();;
        }
    }
    public void update() {
        if (keyH.upPressed == true) {
            y -= speed;
        }
        else if (keyH.downPressed == true) {
            y += speed;
        }
        else if (keyH.leftPressed == true) {
            x -= speed;
        }
        else if (keyH.rightPressed == true) {
            x += speed;
        }
    }
    public void draw(Graphics2D g2) {
        g2.setColor(Color.white);


        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}

