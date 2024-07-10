import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] array = new int[N + 1][N + 1];
        int input, a, b, c, d, result;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0)
                    array[i][j] = 0;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                input = scanner.nextInt();
                array[i][j] = input + array[i][j - 1] + array[i - 1][j] - array[i - 1][j - 1];
            }
        }

//        for (int i = 0; i <= N; i++) {
//            for (int j = 0; j <= N; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < M; i++) {
            b = scanner.nextInt();
            a = scanner.nextInt();
            d = scanner.nextInt();
            c = scanner.nextInt();
            result = array[d][c] - array[d - (d - (b - 1))][c] - array[d][c - (c - (a - 1))] + array[d - (d - (b - 1))][c - (c - (a - 1))];
            System.out.println(result);
        }

        scanner.close();
    }
}