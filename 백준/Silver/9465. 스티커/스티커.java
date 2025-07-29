import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] dp;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[2][n + 1];
            String[] input = br.readLine().split(" ");
            for (int ii = 0; ii < n; ii++) {
                dp[0][ii] = Integer.parseInt(input[ii]);
            }
            input = br.readLine().split(" ");
            for (int ii = 0; ii < n; ii++) {
                dp[1][ii] = Integer.parseInt(input[ii]);
            }
            //
            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];
            for (int ii = 2; ii < n; ii++) {
                dp[0][ii] += Math.max(Math.max(dp[0][ii - 2], dp[1][ii - 2]), dp[1][ii - 1]);
                dp[1][ii] += Math.max(Math.max(dp[1][ii - 2], dp[0][ii - 2]), dp[0][ii - 1]);
            }
            bw.write(String.valueOf(Math.max(dp[0][n - 1], dp[1][n - 1])) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}