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

        solidArea = new Rectangle(0,0,48,48);
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        worldX= gp.tileSize * 5;
        worldY= gp.tileSize * 5;
        speed=4;
        direction = "right";

    }
    public void getPlayerImage() {
        try {
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkright1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkright2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkleft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkleft2.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkup1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkup2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkdown1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/mushroomwalkdown2.png"));



        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if(keyH.rightPressed == true || keyH.leftPressed == true || keyH.upPressed == true || keyH.downPressed == true) {
            if (keyH.upPressed && keyH.rightPressed) {
                direction = "right";
                worldX += speed * 0.707; // Diagonal movement
                worldY -= speed * 0.707;
            } else if (keyH.upPressed && keyH.leftPressed) {
                direction = "left";
                worldX -= speed * 0.707; // Diagonal movement
                worldY -= speed * 0.707;
            } else if (keyH.downPressed && keyH.rightPressed) {
                direction = "right";
                worldX += speed * 0.707; // Diagonal movement
                worldY += speed * 0.707;
            } else if (keyH.downPressed && keyH.leftPressed) {
                direction = "left";
                worldX -= speed * 0.707; // Diagonal movement
                worldY += speed * 0.707;
            } else if (keyH.upPressed) {
                direction = "up";
                worldY -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                worldY += speed;
            } else if (keyH.rightPressed) {
                direction = "right";
                worldX += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                worldX -= speed;
            }
            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (collisionOn == false) {
                switch (direction) {
                case "up" : worldY -= speed ;break;
                case "down": worldY += speed ;break;
                case "left": worldX -= speed;break;
                case "right": worldX += speed;break;
                }
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
        case "up":
            if(spriteNum == 1) {
                image = up1;
            }
            if(spriteNum == 2) {
                image = up2;
            }
            break;
        case "down":
            if(spriteNum == 1) {
                image = down1;
            }
            if(spriteNum == 2) {
                image = down2;
            }
            break;
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

