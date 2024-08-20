import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] array = new int[k + 1][n];

            for (int a = 0; a <= k; a++) {
                for (int b = 0; b < n; b++) {
                    if (b == 0) {
                        array[a][b] = 1;
                    }
                    else if (a == 0) {
                        array[a][b] = b + 1;
                    }
                    else {
                        array[a][b] = array[a - 1][b] + array[a][b - 1];
                    }
                }
            }
//            for (int a = 0; a < k; a++) {
//                for (int b = 0; b < n; b++) {
//                    System.out.print(array[a][b] + " ");
//                }
//                System.out.println();
//            }
            System.out.println(array[k][n - 1]);
        }

        scanner.close();
    }
}