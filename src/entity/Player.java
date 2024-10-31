package entity;


import Main.GamePanel;
import Main.KeyHandler;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Player extends Entity {


    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        solidArea = new Rectangle(0, 0, 48, 48);
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 5;
        worldY = gp.tileSize * 5;
        speed = 4;
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


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.rightPressed || keyH.leftPressed || keyH.upPressed || keyH.downPressed) {

            // Determine direction based on key presses
            if (keyH.upPressed && keyH.rightPressed) {
                direction = "up-right";
                worldX += speed * 0.707 * 0; // Diagonal movement
                worldY -= speed * 0.707 * 0;
            } else if (keyH.upPressed && keyH.leftPressed) {
                direction = "up-left";
                worldX -= speed * 0.707 * 0; // Diagonal movement
                worldY -= speed * 0.707 * 0;
            } else if (keyH.downPressed && keyH.rightPressed) {
                direction = "down-right";
                worldX += speed * 0.707 * 0; // Diagonal movement
                worldY += speed * 0.707 * 0;
            } else if (keyH.downPressed && keyH.leftPressed) {
                direction = "down-left";
                worldX -= speed * 0.707 * 0; // Diagonal movement
                worldY += speed * 0.707 * 0;
            } else if (keyH.upPressed) {
                direction = "up";
                worldY -= speed * 0;
            } else if (keyH.downPressed) {
                direction = "down";
                worldY += speed * 0;
            } else if (keyH.rightPressed) {
                direction = "right";
                worldX += speed * 0;
            } else if (keyH.leftPressed) {
                direction = "left";
                worldX -= speed * 0;
            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (!collisionOn) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                    case "up-right":
                        worldX += speed * 0.707;
                        worldY -= speed * 0.707;
                        break;
                    case "up-left":
                        worldX -= speed * 0.707;
                        worldY -= speed * 0.707;
                        break;
                    case "down-right":
                        worldX += speed * 0.707;
                        worldY += speed * 0.707;
                        break;
                    case "down-left":
                        worldX -= speed * 0.707;
                        worldY += speed * 0.707;
                        break;
                }
            }

            // Update sprite animation
            spriteCounter++;
            if (spriteCounter > 10) {
                spriteNum = spriteNum == 1 ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                }
                break;

            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else if (spriteNum == 2) {
                    image = down2;
                }
                break;

            case "right":
            case "up-right":
            case "down-right":
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                }
                break;

            case "left":
            case "up-left":
            case "down-left":
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                }
                break;
        }

        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
}