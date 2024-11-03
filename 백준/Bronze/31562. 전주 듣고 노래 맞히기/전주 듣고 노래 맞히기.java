import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> hash = new HashMap<>();

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            scanner.nextInt();
            String name = scanner.next();
            String rhythm = "";
            for (int j = 0; j < 3; j++) {
                String temp = scanner.next();
                rhythm += temp;
            }
            for (int j = 0; j < 4; j++) {
                scanner.next();
            }
            if (hash.containsKey(rhythm)) {
                hash.put(rhythm, "");
            }
            else {
                hash.put(rhythm, name);
            }
        }

        for (int i = 0; i < M; i++) {
            String temp = "";
            for (int j = 0; j < 3; j++) {
                temp += scanner.next();
            }
            if (!hash.containsKey(temp))
                System.out.println("!");
            else if (hash.get(temp).equals(""))
                System.out.println("?");
            else
                System.out.println(hash.get(temp));
        }

        scanner.close();
    }
}