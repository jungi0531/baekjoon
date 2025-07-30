import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 2];
        int[] dp = new int[n + 2];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + wine[i], Math.max(dp[i - 1], dp[i - 3] + wine[i - 1] + wine[i]));
        }
        bw.write(String.valueOf(dp[n - 1]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}