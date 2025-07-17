import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] dp;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 3];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int ii = 4; ii <= n; ii++) {
                dp[ii] = dp[ii - 1] + dp[ii - 2] + dp[ii - 3];
            }
            bw.write(String.valueOf(dp[n]) + "\n");

            // 1
            // 1 1, 2
            // 1 1 1, 1 2, 2 1, 3

            // 1 1 1 1
            // 1 1 2, 2 2
            // 1 1 1 1, 1 1 2, 2 1 1, 1 3
        }
        bw.flush();
        bw.close();
        br.close();
    }
}