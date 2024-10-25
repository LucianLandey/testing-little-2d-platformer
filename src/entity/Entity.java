package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
        public int worldX, worldY;
        public int speed;

        public BufferedImage right1, right2, left1, left2;
        public String direction;

        public int spriteCounter =1;
        public int spriteNum= 1;
        public Rectangle solidArea;
        public boolean collisionOn = false;
}
