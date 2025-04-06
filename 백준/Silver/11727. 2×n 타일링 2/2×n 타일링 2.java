import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            // dp식이 n = (n - 1) + 2(n - 2)인 이유
            // n에서 맨 왼쪽 타일이 세로 타일인 경우 -> 남은 타일을 채우는 경우의 수눈 n - 1
            // n에서 맨 왼쪽 타일이 가로 두 개 타일 또는 네모 타일인 경우 -> 각 남은 타일을 채우는 수는 n - 2
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
            if (dp[i] >= 10007)
                dp[i] %= 10007;
        }
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}