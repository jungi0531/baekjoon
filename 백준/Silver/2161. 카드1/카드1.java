import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> q = new ArrayDeque<>();

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }

        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
            if (q.isEmpty()) break;
            q.add(q.poll());
        }

        scanner.close();
    }
}