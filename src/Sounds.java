import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * A simple Java sound file example (i.e., Java code to play a sound file).
 * AudioStream and AudioPlayer code comes from a javaworld.com example.
 *
 * @author alvin alexander, devdaily.com.
 */
public class Sounds {

    public static void playSound(String soundClip, long end) throws Exception {
        // open the sound file as a Java input stream
        String soundFile = "/Users/joe/programming/java/MorseCode/"+soundClip;
        InputStream in = new FileInputStream(soundFile);

        // create an audiostream from the inputstream
        AudioStream audioStream = new AudioStream(in);

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);
        if(System.currentTimeMillis() >= end){
            AudioPlayer.player.stop(audioStream);
        }
    }
}


