package Main;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 px
    final int screenHeight = tileSize * maxScreenRow; // 576 px

    // FPS
    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //set players default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
            double drawInterval = 1000000000/FPS; //.01666 bar
            double nextDrawTime = System.nanoTime() + drawInterval;
            long timer = 0;
            int drawCount = 0;
            while(gameThread != null) {

                //1 Update: update info such as character positions
                update();

                //2 DRAW: draw the screen with the udated info
                repaint();

                try {
                    double remainingTime = nextDrawTime - System.nanoTime();
                    remainingTime = remainingTime/1000000;
                    if(remainingTime < 0) {
                        remainingTime = 0;
                    }
                    Thread.sleep((long) remainingTime);
                    nextDrawTime += drawInterval;
                } catch (InterruptedException e) {
                    // TODO Auto generated catch block
                    throw new RuntimeException(e);
                }
            }
    }
    public void update() {

        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
