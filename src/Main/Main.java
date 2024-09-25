package Main;

import javax.swing.JFrame;
//LUCIAN IMPORTANT!!!! ALL YOUR CODE IS IN A DOC IN YOUR SCHOOL ACCOUNT FOR THE PLAYER FILE. GO TO THE COMENTS OF SPRITE AND ANIMATION VIDEO READ HOW TO DO IT FOR INTELLIJ.

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure Fun");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();
    }
}
