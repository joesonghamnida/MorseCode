import javax.sound.midi.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, String> letterToCode = new HashMap<>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        mapLettersToCode(letterToCode);
        String morseCode = printCode();
        //codeToSound(morseCode);
        
    }

    public static String printCode() {

        System.out.println("please enter your message: ");
        String message = scanner.nextLine();

        String morseCode = "";
        for (int i = 0; i < message.length(); i++) {
            for (String letter : letterToCode.keySet()) {
                if (letter.equals(message.substring(i, i + 1).toLowerCase())) {
                    morseCode += letterToCode.get(letter) + " / ";
                }
            }
        }
        System.out.println(morseCode);
        return morseCode;
    }

    public static void codeToSound(String morseCode) throws InterruptedException, MidiUnavailableException, InvalidMidiDataException {
        int dot = 200;
        int dash = 600;
        int silence = 1000;

        Synthesizer synth = MidiSystem.getSynthesizer();
        Receiver synthRcvr = synth.getReceiver();

        for (int i = 0; i < morseCode.length(); i++) {
            synth.open();
            if (morseCode.charAt(i) == '.') {
                //synth.open();
                //Receiver synthRcvr = synth.getReceiver();
                ShortMessage msg = new ShortMessage();
                msg.setMessage(ShortMessage.NOTE_ON, i, 60, 93);
                synthRcvr.send(msg, -1);
                synthRcvr.close();
            } else if (morseCode.charAt(i) == '-') {
                //synth.open();
                //Receiver synthRcvr = synth.getReceiver();
                ShortMessage msg = new ShortMessage();
                msg.setMessage(ShortMessage.NOTE_ON, i, 60, 93);
                synthRcvr.send(msg, -1);
                synthRcvr.close();
            } else if (morseCode.charAt(i) == '/' || morseCode.charAt(i) == ' ') {

            }
        }
    }

    /*ShortMessage myMsg = new ShortMessage();
        // Play the note Middle C (60) moderately loud
        // (velocity = 93)on channel 4 (zero-based).
        myMsg.setMessage(ShortMessage.NOTE_ON, 4, 60, 93);
        Synthesizer synth = MidiSystem.getSynthesizer();
        Receiver synthRcvr = synth.getReceiver();
        synthRcvr.send(myMsg, -1); // -1 means no time stamp*/

        /*Synthesizer synth = MidiSystem.getSynthesizer();
        MidiChannel chan[] = synth.getChannels();


        // Check for null; maybe not all 16 channels exist.
        for (int i = 0; i < 16; i++) {
            if (chan[i] != null) {
                //chan[i].noteOn(60, 93);
                System.out.println(i);
                synth.open();
                Receiver synthRcvr = synth.getReceiver();
                ShortMessage msg = new ShortMessage();
                msg.setMessage(ShortMessage.NOTE_ON, i, 60, 93);
                synthRcvr.send(msg, -1);
                synthRcvr.close();
                Thread.sleep(250);
            }
        }*/

    /*
    @Deprecated
    public static void codeToSound(String morseCode) throws InterruptedException {
        int dot = 200;
        int dash = 600;
        int silence = 1000;

        for (int i = 0; i < morseCode.length(); i++) {
            if (morseCode.charAt(i) == '.') {
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(dot);
            } else if (morseCode.charAt(i) == '-') {
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(dash);
            } else if (morseCode.charAt(i) == '/' || morseCode.charAt(i) == ' ') {
                Thread.sleep(silence);
            }
        }
    }

    @Deprecated
    public static void codeToSound(String morseCode) throws Exception {
        for (int i = 0; i < morseCode.length(); i++) {
            int time = 0;
            String soundClip = "";
            if (morseCode.charAt(i) == '.') {
                time = 10;
                soundClip = "e.wav";
            } else if (morseCode.charAt(i) == '-') {
                time = 50;
                soundClip = "iineShort.wav";
            }

            long t = System.currentTimeMillis();
            long end = t + time;

            while (System.currentTimeMillis() < end) {
                Sounds.playSound(soundClip, end);
                Thread.interrupted();
                Thread.yield();
            }
            Thread.sleep(1000);
        }
        System.out.println("transmission over");
        System.exit(0);
    }*/

    public static void mapLettersToCode(HashMap<String, String> letterToCode) {
        letterToCode.put("a", ".-");
        letterToCode.put("b", "-...");
        letterToCode.put("c", "-.-.");
        letterToCode.put("d", "-..");
        letterToCode.put("e", ".");
        letterToCode.put("f", "..-.");
        letterToCode.put("g", "--.");
        letterToCode.put("h", "....");
        letterToCode.put("i", "..");
        letterToCode.put("j", ".---");
        letterToCode.put("k", "-.-");
        letterToCode.put("l", ".-..");
        letterToCode.put("m", "--");
        letterToCode.put("n", "-.");
        letterToCode.put("o", "---");
        letterToCode.put("p", ".--.");
        letterToCode.put("q", "--.-");
        letterToCode.put("r", ".-.");
        letterToCode.put("s", "...");
        letterToCode.put("t", "-");
        letterToCode.put("u", "..-");
        letterToCode.put("v", "...-");
        letterToCode.put("w", ".--");
        letterToCode.put("x", "-..-");
        letterToCode.put("y", "-.--");
        letterToCode.put("z", "--..");
    }

}
