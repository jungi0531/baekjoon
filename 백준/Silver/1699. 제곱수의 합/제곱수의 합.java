import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        br.close();
        int[] dp = new int[N + 1];

        //
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            for (int ii = 1; ii * ii <= i; ii++) {
                if (dp[i] > dp[i - (ii * ii)] + 1) {
                    dp[i] = dp[i - (ii * ii)] + 1;
                }
            }
        }

        // 출력
        System.out.println(dp[N]);
    }
}