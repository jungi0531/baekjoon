import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = scanner.nextInt();
        int H = scanner.nextInt();
        int T = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            pq.add(scanner.nextInt());
        }
        for (int i = 0; i < T; i++) {
            if (pq.peek() < H) break;

            int temp = pq.poll();

            if (temp > 1) {
                temp /= 2;
                count++;
            }
            pq.add(temp);
            //System.out.println("temp: " + temp);
        }
        if (H <= pq.peek()) {
            System.out.println("NO");
            System.out.println(pq.peek());
        }
        else {
            System.out.println("YES");
            System.out.println(count);
        }
        scanner.close();
    }
}