package entity;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

        GamePanel gp;
        public int worldX, worldY;
        public int speed;

        public BufferedImage right1, right2, left1, left2, up1, up2, down1, down2;
        public String direction;

        public int spriteCounter =1;
        public int spriteNum= 1;
        public Rectangle solidArea = new Rectangle(0,0,48,48);
        public int solidAreaDefaultX, solidAreaDefaultY;
        public boolean collisionOn = false;

        public Entity(GamePanel gp) {
                this.gp =gp;
        }
        public void update() {
                setAction();

                collisionOn = false;
                gp.cChecker.checkTile(this);
                //gp.cChecker.checkObject(this, false);


        }
}
