import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] array = new int[N];
        int[] sumArray = new int[N + 1];
        int a, b;

        sumArray[0] = 0;
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
            sumArray[i + 1] = sumArray[i] + array[i];
        }
        for (int i = 0; i < M; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(sumArray[b] - sumArray[a - 1]);
        }
        scanner.close();
    }
}