import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        // 입력 값이 하나이므로 n까지만 dp 식을 구하면 됨
        for (int i = 3; i <= n; i++) {
            // 피보나치 수열 규칙인 이유
            // n에서 왼쪽에 가로 직사각형 2개를 붙인 경우: 나머지 칸에 n - 2 경우의 수로 채우면 됨
            // n에서 왼쪽에 세로 직사각형 1개를 붙인 경우: 나머지 칸에 n - 1 경우의 수로 채우면 됨
            dp[i] = dp[i - 1] + dp[i - 2];
            // 답에서 10007의 나머지로 답을 출력하라고 했기에
            // 10007이 넘으면 모듈러 연산 해주기
            if (dp[i] >= 10007) {
                dp[i] %= 10007;
            }
        }
        bw.write(String.valueOf(dp[n]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}