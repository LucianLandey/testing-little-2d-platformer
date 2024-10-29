package Main;

import object.OBJ_power;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject() {
        gp.obj[0] = new OBJ_power();
        gp.obj[0].worldX = 4 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new OBJ_power();
        gp.obj[1].worldX = 3 * gp.tileSize;
        gp.obj[1].worldY = 2  * gp.tileSize;

    }
}
