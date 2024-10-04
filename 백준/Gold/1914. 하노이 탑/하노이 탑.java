import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 원판의 개수 N 입력 받기
        int N = scanner.nextInt();

        // 일반화 식 (2^n) - 1
        BigInteger K = BigInteger.TWO.pow(N).subtract((BigInteger.ONE));
        // 옮긴 횟수 K 출력
        System.out.println(K);

        // N이 20이하면 수행 과정 출력
        if (N <= 20) {
            printHanoi(N, 1, 3, 2);
        }
        scanner.close();
    }
    // 수행 과정 출력 함수
    public static int printHanoi(int N, int from, int to, int by) {
        if (N == 1) {
            System.out.println(from + " " + to);
            return 1;
        }
        return printHanoi(N - 1, from, by, to) + printHanoi(1, from, to, by) + printHanoi(N - 1, by, to, from);
    }
}