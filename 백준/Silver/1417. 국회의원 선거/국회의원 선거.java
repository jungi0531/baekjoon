import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int count = 0;
        int N = scanner.nextInt();
        int dasom = scanner.nextInt();

        for (int i = 0; i < N - 1; i++) {
            pq.add(scanner.nextInt());
        }
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int temp = pq.poll();
            temp--;
            dasom++;
            count++;
            pq.add(temp);
        }
        System.out.println(count);

        scanner.close();
    }
}