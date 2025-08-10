import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine()); br.close();
        int[] dp = new int[N + 2];
        // 
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= N; i += 2) {
            dp[i] = 3 * dp[i - 2];
            for (int ii = i - 4; ii >= 0; ii--) {
                dp[i] += 2 * dp[ii];
            }
        }
        // 출력
        System.out.println(dp[N]);
    }
}