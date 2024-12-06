package entity;

import Main.GamePanel;

import java.util.Random;

public class NPC_Spider extends Entity{

    public NPC_Spider(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
    }
    public void getImage() {
        right1 = setup("/npc/spiderright1");
        right2 = setup("/npc/spiderright2");
        left1 = setup("/npc/spiderleft1");
        left2 = setup("/npc/spiderleft2");
        up1 = setup("/npc/spiderup1");
        up2 = setup("/npc/spiderup2");
        down1 = setup("/npc/spiderdown1");
        down2 = setup("/npc/spiderdown2");

    }
    public void setDialogue() {
        dialogues[0] = "HELLO, I AM THE ANGRY SPIDER";
        dialogues[1] = "I HATE EVERYTHING";
        dialogues[2] = "I AM SUPPOSED TO BE AN ENEMY";
        dialogues[3] = "SPIDER";
        dialogues[4] = "SPIDER2";
    }
    public void setAction() {
        actionLockCounter ++;
        if(actionLockCounter == 120){
            Random random = new Random();
            int i = random.nextInt(100)+1; //pick num from 1-100
            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i >75 && i <= 100) {
                direction = "right";
            }
            actionLockCounter = 0;
        }

    }
    public void speak() {
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
    }
}
