package entity;


import Main.GamePanel;
import Main.KeyHandler;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
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
        worldX=100;
        worldY= 100;
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
            e.printStackTrace();
        }
    }
    public void update() {
        if(keyH.rightPressed == true || keyH.leftPressed == true || keyH.upPressed == true || keyH.downPressed == true) {
            if (keyH.upPressed == true) {
                worldY -= speed;
            }
            if (keyH.downPressed == true) {
                worldY += speed;
            }
            if (keyH.rightPressed == true) {
                direction = "right";
                worldX+= speed;
            }
            if (keyH.leftPressed == true) {
                direction = "left";
                worldX  -= speed;
            }
            spriteCounter ++;
            if(spriteCounter > 10) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2) {
                    spriteNum = 1;

                }
                spriteCounter = 0;
            }
        }

    }
    public void draw(Graphics2D g2) {
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);


        BufferedImage image = null;
        switch (direction) {
        case "right":
            if(spriteNum == 1) {
                image = right1;
            }
            if(spriteNum == 2) {
                image = right2;
            }
            break;
        case "left":
            if(spriteNum == 1) {
                image = left1;
            }
            if(spriteNum == 2) {
                image = left2;
            }
            break;


        }
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}

