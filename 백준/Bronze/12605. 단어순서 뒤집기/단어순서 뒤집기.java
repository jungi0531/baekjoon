import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            String[] temp = input.split(" ");

            System.out.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < temp.length; j++) {
                System.out.print(temp[temp.length - (j + 1)] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}