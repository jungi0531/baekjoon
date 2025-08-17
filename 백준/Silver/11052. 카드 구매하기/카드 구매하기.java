import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] pack = new int[N + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            pack[i + 1] = Integer.parseInt(input[i]);
        }

        //
        dp[1] = pack[1];
        for (int i = 2; i <= N; i++) {
            for (int ii = 1; ii <= i; ii++) {
                dp[i] = Math.max(dp[i], dp[i - ii] + pack[ii]);
            }
        }

        // 출력
        System.out.println(dp[N]);
    }
}