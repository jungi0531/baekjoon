import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        int N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            String[] temp = input.split(" ");
            for (int j = 0; j < temp.length; j++) {
                stack.push(temp[j]);
            }

            System.out.print("Case #" + (i + 1) + ": ");
            while (!stack.empty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}