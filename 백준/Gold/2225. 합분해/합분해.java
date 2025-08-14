import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 초기화
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= K; i++) {
            dp[0][i] = 1;
        }

        //
        for (int i = 1 ; i <= N; i++) {
            for (int ii = 1; ii <= K; ii++) {
                dp[i][ii] = dp[i - 1][ii] + dp[i][ii - 1];
                dp[i][ii] %= 1_000_000_000;
            }
        }

        // 출력
        System.out.println(dp[N][K]);
    }
}