import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int S = 0;

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            S += A[i] * B[N - (i + 1)];
        }
        System.out.println(S);

        scanner.close();
    }
}