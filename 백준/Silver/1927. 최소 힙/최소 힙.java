import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            int input = scanner.nextInt();

            if (input == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                }
                else {
                    System.out.println(pq.poll());
                }
            }
            else {
                pq.add(input);
            }
        }
        scanner.close();
    }
}