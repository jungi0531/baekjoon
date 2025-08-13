import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int T = Integer.parseInt(br.readLine());
        int[] input = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(br.readLine());
            if (input[i] > max)
                max = input[i];
        }

        //
        long[] dp = new long[max + 5];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for (int i = 6; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        // 출력
        for (int i = 0; i < T; i++) {
            bw.write(String.valueOf(dp[input[i]]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}