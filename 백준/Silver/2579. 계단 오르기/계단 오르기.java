import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[][] dp = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // 2차원 배열 제작
        // 첫 배열에는 이전 한 칸, 두 번째 배열에는 이전 한 칸 점프한 값
        // 다음 계단 밟았으면 다음은 무조건 한 칸 건너뛰기
        dp[0][0] = stairs[0];
        dp[0][1] = stairs[0];
        dp[1][0] = dp[0][0] + stairs[1];
        dp[1][1] = stairs[1];

        for (int i = 2; i < N; i++) {
            for (int ii = 0; ii < 2; ii++) {
                if (ii == 0) {
                    dp[i][ii] = dp[i - 1][1] + stairs[i];
                } else {
                    dp[i][ii] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
                }
            }
        }

        // 출력
        System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
    }
}