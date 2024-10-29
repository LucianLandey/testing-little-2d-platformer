package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_power extends SuperObject{

    public OBJ_power() {

        name = "power";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/powerup1.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
