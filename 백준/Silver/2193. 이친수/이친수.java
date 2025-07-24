import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 2];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        bw.write(String.valueOf(dp[N]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}