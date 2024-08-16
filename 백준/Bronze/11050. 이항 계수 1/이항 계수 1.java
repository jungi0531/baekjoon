import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        System.out.println(cb(N, K));

        scanner.close();
    }
    public static int cb(int N, int K) {
        if (K == 0 || N == K) {
            return 1;
        }
        else {
            return cb(N - 1, K - 1) + cb(N - 1, K);
        }
    }
}