package object;

import Main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);

    public void draw(Graphics2D g2, GamePanel gp) {
//        int screenX = worldX - gp.player.worldX + gp.player.screnX;
    }
}
