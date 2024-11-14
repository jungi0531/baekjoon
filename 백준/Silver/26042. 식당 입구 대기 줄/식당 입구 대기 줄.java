import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> q = new ArrayDeque<>();

        int maxQueueSize = 0, lastStudentNum = 0;
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            if (input == 1) {
                q.add(scanner.nextInt());
            } else if (input == 2) {
                q.poll();
            }
            if (maxQueueSize < q.size()) {
                // 정보 저장
                maxQueueSize = q.size();
                lastStudentNum = q.peekLast();
            } else if (maxQueueSize == q.size()) {
                // 맨 뒤 값 더 작은 경우 저장
                if (q.peekLast() < lastStudentNum) {
                    lastStudentNum = q.peekLast();
                }
            }
        }
        System.out.println(maxQueueSize + " " + lastStudentNum);

        scanner.close();
    }
}