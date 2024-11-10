import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            String input = scanner.next();
            if (input.equals("push")) {
                queue.add(scanner.nextInt());
            }
            else if (input.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.poll());
                }
            }
            else if (input.equals("size")) {
                System.out.println(queue.size());
            }
            else if (input.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            else if (input.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.peek());
                }
            }
            else if (input.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(((LinkedList<Integer>) queue).getLast());
                }
            }
        }

        scanner.close();
    }
}