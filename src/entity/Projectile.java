package entity;

import Main.GamePanel;
import Main.KeyHandler;

public class Projectile extends Entity {

   Entity user;

   public Projectile(GamePanel gp) {
      super(gp);
   }
   public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
            this.worldX = worldX;
            this.worldY = worldY;
            this.direction = direction;
            this.alive = alive;
            this.user = user;
            this.life = this.maxLife;
   }
   public void update() {
      switch(direction){
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

      life--;
      if(life<= 0){
         alive = false;
      }

      spriteCounter++;
      if(spriteCounter > 12) {
         if(spriteNum == 1){
            spriteNum = 2;
         } else if (spriteNum == 2) {
            spriteNum = 1;
         }
         spriteCounter =0;

      }
   }
}

