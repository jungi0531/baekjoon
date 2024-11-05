import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hash = new HashSet<>();

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            hash.add(scanner.next());
        }

        for (String temp : hash) {
            StringBuffer sb = new StringBuffer(temp);
            String reverse = sb.reverse().toString();
            if (hash.contains(reverse)) {
                System.out.println(reverse.length() + " " + reverse.charAt(reverse.length() / 2));
                break;
            }
        }

        scanner.close();
    }
}