package entity;

import Main.GamePanel;
import Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {

        GamePanel gp;
        public int worldX, worldY;

        public BufferedImage right1, right2, left1, left2, up1, up2, down1, down2;
        public String direction = "down";

        public int spriteCounter =1;
        public int spriteNum= 1;
        public Rectangle solidArea = new Rectangle(0,0,48,48);
        public int solidAreaDefaultX, solidAreaDefaultY;
        public boolean collisionOn = false;
        public int actionLockCounter = 0;
        String dialogues[] = new String[20];
        int dialogueIndex = 0;
        public BufferedImage image, image2, image3, image1;
        public String name;
        public boolean collision = false;

        public boolean alive = true;
        public boolean dying = false;

       //CHARACTER ATTRIBUTES
        public int speed;
        public int life;
        public int maxLife;
        public Projectile projectile;


        public Entity(GamePanel gp) {
                this.gp =gp;
        }
        public BufferedImage setup(String imagePath) {
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try{
            image = ImageIO.read(getClass().getResourceAsStream( imagePath + ".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
        public void setAction() {}
        public void speak() {

            if(dialogues[dialogueIndex] == null){
                dialogueIndex = 0;
            }
            gp.ui.currentDialogue = dialogues[dialogueIndex];
            dialogueIndex++;

            switch(gp.player.direction) {
                case "up": direction = "down";break;
                case "down": direction = "up";break;
                case "left": direction = "right";break;
                case "right": direction = "left";break;
            }
        }
        public void update() {
            setAction();

            collisionOn = false;
            gp.cChecker.checkTile(this);
            //gp.cChecker.checkObject(this, false);
            gp.cChecker.checkPlayer(this);

            // MORE CODE FROM ENTITY
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
        public void draw(Graphics2D g2) {
            BufferedImage image = null;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

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

                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);

        }
}
