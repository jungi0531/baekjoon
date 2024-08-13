import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] array = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            array[i] = 0;
        }
        for (int i = 2; i <= N; i++) {
            if (array[i] == 0 && i >= M) {
                System.out.println(i);

            }
            for (int j = 2; i * j <= N; j++) {
                array[i * j] = 1;
            }
        }
        scanner.close();
    }
}