package Main;

import entity.Entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        // Check for diagonal movement by combining both directions
        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;

            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;

            // Diagonal movement cases
            case "up-right":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow + 1];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;

            case "up-left":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow + 1];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;

            case "down-right":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow - 1];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;

            case "down-left":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow - 1];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }
    }
    //NPC OR MONSTER COLLISION
    public int checkEntity(Entity entity, Entity[] target) {
         int index = 999;

         for(int i = 0; i < target.length; i++) {
             if(target[i] != null) {
                 //Get entity's solid area position
                 entity.solidArea.x = entity.worldX + entity.solidArea.x;
                 entity.solidArea.y = entity.worldY + entity.solidArea.y;
                 //Get the objects solid area pos
                 target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                 target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

                 switch(entity.direction){
                     case"up":
                         entity.solidArea.y -= entity.speed;
                         if(entity.solidArea.intersects(target[i].solidArea)) {
                                 entity.collisionOn = true;
                                 index = i;
                         }
                         break;
                     case"down":
                         entity.solidArea.y += entity.speed;
                         if(entity.solidArea.intersects(target[i].solidArea)) {
                                 entity.collisionOn = true;
                                 index = i;
                         }
                         break;
                     case "left":
                         entity.solidArea.x -= entity.speed;
                         if(entity.solidArea.intersects(target[i].solidArea)) {
                                 entity.collisionOn = true;
                                 index = i;
                         }
                         break;
                     case"right":
                         entity.solidArea.x += entity.speed;
                         if(entity.solidArea.intersects(target[i].solidArea)) {
                                 entity.collisionOn = true;
                                 index = i;

                         }
                         break;
                     case "up-right":
                         entity.solidArea.y -= entity.speed;
                         entity.solidArea.x += entity.speed;
                         if(entity.solidArea.intersects(target[i].solidArea)) {
                             entity.collisionOn = true;
                             index = i;
                         }
                         break;
                     case "down-right":
                         entity.solidArea.y += entity.speed;
                         entity.solidArea.x += entity.speed;
                         if(entity.solidArea.intersects(target[i].solidArea)) {
                             entity.collisionOn = true;
                             index = i;
                         }
                         break;
                     case "down-left":
                         entity.solidArea.y += entity.speed;
                         entity.solidArea.x -= entity.speed;
                         if(entity.solidArea.intersects(target[i].solidArea)) {
                             entity.collisionOn = true;
                             index = i;
                         }
                         break;
                     case "up-left":
                         entity.solidArea.y -= entity.speed;
                         entity.solidArea.x -= entity.speed;
                         if(entity.solidArea.intersects(target[i].solidArea)) {
                             entity.collisionOn = true;
                             index = i;
                         }
                         break;
                }entity.solidArea.x = entity.solidAreaDefaultX;
                 entity.solidArea.y = entity.solidAreaDefaultY;
                 target[i].solidArea.x = target[i].solidAreaDefaultX;
                 target[i].solidArea.y = target[i].solidAreaDefaultY;
             }
         }
        return index;
    }
    public void checkPlayer(Entity entity) {
        //Get entity's solid area position
        entity.solidArea.x = entity.worldX + entity.solidArea.x;
        entity.solidArea.y = entity.worldY + entity.solidArea.y;
        //Get the objects solid area pos
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

        switch(entity.direction){
            case"up":
                entity.solidArea.y -= entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
            case"down":
                entity.solidArea.y += entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entity.solidArea.x -= entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
            case"right":
                entity.solidArea.x += entity.speed;
                if(entity.solidArea.intersects(gp.player.solidArea)) {
                    entity.collisionOn = true;
                }
                break;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
    }
}
