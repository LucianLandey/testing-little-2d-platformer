package object;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Heart extends SuperObject{
    GamePanel gp;
    public OBJ_Heart(GamePanel gp) {

        name = "Heart";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/heart.png"));
            image2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/halfheart.png"));
            image3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/noheart.png"));
            image = uTool.scaleImage(image, 48, 48);
            image2 = uTool.scaleImage(image2, 48, 48);
            image3 = uTool.scaleImage(image3, 48, 48);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
