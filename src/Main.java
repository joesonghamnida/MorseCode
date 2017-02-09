import javax.sound.midi.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HashMap<String, String> letterToCode = new HashMap<>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        mapLettersToCode(letterToCode);
        String morseCode = printCode();

        codeToSound(morseCode);
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
        Synthesizer synth = MidiSystem.getSynthesizer();

        for (int i = 0; i < morseCode.length(); i++) {
            if (morseCode.charAt(i) == '.') {
                synth.open();
                Receiver synthRcvr = synth.getReceiver();
                ShortMessage msg = new ShortMessage();
                msg.setMessage(ShortMessage.NOTE_ON, 4, 60, 93);
                synthRcvr.send(msg, 25);
                synthRcvr.close();
                Thread.sleep(250);
            }
            else if(morseCode.charAt(i) == '-'){
                synth.open();
                Receiver synthRcvr = synth.getReceiver();
                ShortMessage msg = new ShortMessage();
                msg.setMessage(ShortMessage.NOTE_ON, 4, 75, 93);
                synthRcvr.send(msg, 60);
                synthRcvr.close();
                Thread.sleep(250);
            }
            else{
                Thread.sleep(1000);
            }
        }
    }

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
