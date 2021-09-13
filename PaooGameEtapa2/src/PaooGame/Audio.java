package PaooGame;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Audio  extends JFrame {

       public static  Clip clip ;
       public static  boolean on_off = true;
    public Audio() {

        try {
             clip= AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Main.class.getResourceAsStream("music.wav"));
            clip.open(inputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            System.out.println(clip);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void setAudioOnOff(boolean music){


        if(music == true) {
            clip.start();
        }
        else {
            clip.stop();
        }
    }

}
