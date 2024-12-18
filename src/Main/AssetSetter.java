package Main;

import entity.NPC_Spider;
import object.OBJ_power;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {
        gp.obj[0] = new OBJ_power(gp);
        gp.obj[0].worldX = 21 * gp.tileSize;
        gp.obj[0].worldY = 23 * gp.tileSize;

        gp.obj[1] = new OBJ_power(gp);
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 25  * gp.tileSize;

    }
    public void setNPC () {
        gp.npc[0] = new NPC_Spider(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;
        gp.npc[1] = new NPC_Spider(gp);
        gp.npc[1].worldX = gp.tileSize*24;
        gp.npc[1].worldY = gp.tileSize*24;
        gp.npc[2] = new NPC_Spider(gp);
        gp.npc[2].worldX = gp.tileSize*23;
        gp.npc[2].worldY = gp.tileSize*22;

    }
}
