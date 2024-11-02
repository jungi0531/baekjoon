import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean result = false;

        String input;
        String[] fruit = {"STRAWBERRY", "BANANA", "LIME", "PLUM"};
        int[] count = {0, 0, 0, 0};

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            input = scanner.next();
            for (int j = 0; j < fruit.length; j++) {
                if (input.equals(fruit[j])) count[j] += scanner.nextInt();
            }
        }

        for (int i = 0; i < fruit.length; i++) {
            if (count[i] == 5) result = true;
        }
        if (result) System.out.println("YES");
        else System.out.println("NO");

        scanner.close();
    }
}