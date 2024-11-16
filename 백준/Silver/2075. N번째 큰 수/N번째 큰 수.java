import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < N; ii++) {
                pq.add(scanner.nextInt());
            }
        }
        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());

        scanner.close();
    }
}