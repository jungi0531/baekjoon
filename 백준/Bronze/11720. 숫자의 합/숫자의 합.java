import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result = 0;
        int n = scanner.nextInt();
        String input = scanner.next();

        for (int i = 0; i < n; i++) {
            result += input.charAt(i) - '0';
        }

        System.out.println(result);
        scanner.close();
    }
}