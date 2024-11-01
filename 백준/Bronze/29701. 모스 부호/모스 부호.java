import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> hash = new HashMap<>();
        String[] inputString = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                ",", ".", "?", ":", "-", "@"};
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-",
                ".....", "-....", "--...", "---..", "----.", "-----", "--..--", ".-.-.-",
                "..--..", "---...", "-....-", ".--.-."};

        for (int i = 0; i < inputString.length; i++) {
            hash.put(morse[i], inputString[i]);
        }

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String input = scanner.next();
            System.out.print(hash.get(input));
        }

        System.out.println();
        scanner.close();
    }
}