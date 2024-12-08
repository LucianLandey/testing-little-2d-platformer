package entity;


import Main.GamePanel;
import Main.KeyHandler;


import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Entity {


    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);

        this.keyH = keyH;
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(0, 0, 48, 48);
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "right";

        //PLAYER STATUS
        maxLife = 6;
        life = maxLife;

    }

    public void getPlayerImage() {
        right1 = setup("/player/mushroomwalkright1");
        right2 = setup("/player/mushroomwalkright2");
        left1 = setup("/player/mushroomwalkleft1");
        left2 = setup("/player/mushroomwalkleft2");
        up1 = setup("/player/mushroomwalkup1");
        up2 = setup("/player/mushroomwalkup2");
        down1 = setup("/player/mushroomwalkdown1");
        down2 = setup("/player/mushroomwalkdown2");

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

            //CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            //CHECK EVENT
            gp.eHandler.checkEvent();
            gp.keyH.zPressed = false;



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

    public void interactNPC(int i ) {

        if(i != 999) {
            if (gp.keyH.zPressed == true){
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();

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

        g2.drawImage(image, screenX, screenY, null);
    }
}