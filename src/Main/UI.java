package Main;


import entity.Entity;
import object.OBJ_Heart;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font prstartk, vgafix, VINERITC, purisa;
    BufferedImage heart, halfheart, noheart;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter =0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int commandNum = 0;

    public UI(GamePanel gp) {
        this.gp = gp;

        try {
            InputStream is = getClass().getResourceAsStream("/font/Purisa Bold.ttf");
            purisa = Font.createFont(Font.TRUETYPE_FONT, is);
//            is = getClass().getResourceAsStream("/font/vgafix.fon");
//            vgafix = Font.createFont(Font.TRUETYPE_FONT, is);
//            is = getClass().getResourceAsStream("/font/VINERITC.ttf");
//            VINERITC = Font.createFont(Font.TRUETYPE_FONT, is);
//            is = getClass().getResourceAsStream("/font/prstartk.ttf");
//            prstartk = Font.createFont(Font.TRUETYPE_FONT, is);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //CREATE HUD OBJECT
        Entity heartobj = new OBJ_Heart(gp);
        heart = heartobj.image1;
        halfheart = heartobj.image2;
        noheart = heartobj.image3;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2) {
        this.g2 =g2;

        g2.setFont(purisa);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.white);

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        // PLAY STATE
        if(gp.gameState == gp.playState) {
            drawPlayerLife();
        }
        //PAUSE STATE
        if(gp.gameState == gp.pauseState) {
            drawPlayerLife();
            drawPauseScreen();
        }
        // DIALOGUE STATE
        if(gp.gameState == gp.dialogueState) {
            drawPlayerLife();
            drawDialogueScreen();
        }
    }
    public void drawPlayerLife() {

        int x= gp.tileSize/2;
        int y= gp.tileSize/2;
        int i =0;
        //DRAW BLANK HEART
        while(i < gp.player.maxLife/2){
            g2.drawImage(noheart, x, y, null);
            i++;
                    x += gp.tileSize;
        }
        x= gp.tileSize/2;
        y= gp.tileSize/2;
        i =0;
        //DRAW CURRENT HEART
        while(i < gp.player.life){
            g2.drawImage(halfheart, x, y, null);
            i++;
            if(i < gp.player.life){
                g2.drawImage(heart, x, y, null);
            }
            i++;
            x += gp.tileSize;
        }

    }
    public void drawTitleScreen(){
        g2.setColor(new Color(115, 24, 165));
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        //GAME NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,40f));
        String text = "MUSHROOM FUCKS SHIT UP";
        int x = getXforCenteredText(text);
        int y = gp.tileSize*2;

        //SHADOW
        g2.setColor(Color.black);
        g2.drawString(text,x+5,y+5);
        //MAIN COLOR
        g2.setColor(Color.WHITE);
        g2.drawString(text,x,y);

        //MUSHROOM IMAGE
        x=gp.screenWidth/2 - (gp.tileSize);
        y += gp.tileSize*2;
        g2.drawImage(gp.player.down1,x,y,gp.tileSize*2,gp.tileSize*2,null);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));

        text = "NEW GAME";
        x = getXforCenteredText(text);
        y+= gp.tileSize*4;
        g2.drawString(text,x,y);
        if(commandNum == 0){
            g2.drawString("-",x-gp.tileSize,y);
        }

        text = "LOAD GAME";
        x = getXforCenteredText(text);
        y+= gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 1){
            g2.drawString("-",x-gp.tileSize,y);
        }

        text = "QUIT";
        x = getXforCenteredText(text);
        y+= gp.tileSize;
        g2.drawString(text,x,y);
        if(commandNum == 2){
            g2.drawString("-",x-gp.tileSize,y);
        }
    }
    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80));
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text,x,y);
    }
    public void drawDialogueScreen(){
        //WINDOW
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*3;
        drawSubWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20F));
        x += gp.tileSize - 25;
        y +=gp.tileSize;

        for(String line: currentDialogue.split("\n")){
            g2.drawString(line,x,y);
            y +=25;
        }

    }
    public void drawSubWindow(int x, int y, int width, int height){
        Color c= new Color(171, 0, 255,200);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);

        c = new Color(0,0,0);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return  x;
    }
}
