import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by joe on 1/26/17.
 */
public class Main {

    public static HashMap<String, String> letterToCode = new HashMap<>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mapLettersToCode(letterToCode);

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
