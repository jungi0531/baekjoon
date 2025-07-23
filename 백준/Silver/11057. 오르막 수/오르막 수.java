import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int MOD = 10007;
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int ii = 0; ii < 10; ii++) {
                dp[i][0] += dp[i - 1][ii];
            }
            dp[i][0] %= MOD;
            for (int ii = 1; ii < 10; ii++) {
                dp[i][ii] = (dp[i][ii - 1] - dp[i - 1][ii - 1]) + MOD;
                dp[i][ii] %= MOD;
            }
        }

        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
            result %= MOD;
        }
        bw.write(String.valueOf(result) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}