package Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {

        soundURL[0] = getClass().getResource("/sound/mushroomgamesong.wav");
        soundURL[1] = getClass().getResource("/sound/blahblahblah.wav");
        soundURL[2] = getClass().getResource("/sound/shot.wav");
        soundURL[3] = getClass().getResource("/sound/shot2.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            //REDUCES NOISE OF SOUND EFFECTS CUZ ANNOYING
            if(i == 2 || i == 3){
                FloatControl gainControl =
                        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                float randomSoundDecrease = (float) ((Math.random() * 3)+10);
                gainControl.setValue(-1 * randomSoundDecrease); // Reduce volume by 10 decibels.
            }


        }catch (Exception e){

        }

    }

    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }
}
