import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = -1;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0)
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            if (i % 3 == 0)
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
        }
        // output
        bw.write(String.valueOf(dp[N]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}