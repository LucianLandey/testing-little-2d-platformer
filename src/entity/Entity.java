package entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

        GamePanel gp;
        public int worldX, worldY;

        public BufferedImage right1, right2, left1, left2, up1, up2, down1, down2;
        public String direction;

        public int spriteCounter =1;
        public int spriteNum= 1;
        public Rectangle solidArea = new Rectangle(0,0,48,48);
        public int solidAreaDefaultX, solidAreaDefaultY;
        public boolean collisionOn = false;

       //CHARACTER ATTRIBUTES
        public String name;
        public int speed;
        public int life;
        public int maxLife;
        public Projectile projectile;


        public Entity(GamePanel gp) {
                this.gp =gp;
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
        }
        public void update() {
                //setAction();

                collisionOn = false;
                gp.cChecker.checkTile(this);
                //gp.cChecker.checkObject(this, false);
                gp.cChecker.checkPlayer(this);

                // MORE CODE FROM ENTITY
        }
}
