import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MOD = 1_000_000_000;

        // 입력
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

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
                dp[i][ii] %= MOD;
            }
        }

        // 출력
        System.out.println(dp[N][K]);
    }
}