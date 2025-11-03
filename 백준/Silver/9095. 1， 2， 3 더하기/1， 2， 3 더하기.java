import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //
        int T = Integer.parseInt(br.readLine());
        int[] n = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            n[i] = Integer.parseInt(br.readLine());
            max = Math.max(n[i], max);
        }
        int[] dp = new int[max + 3];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for (int i = 0; i < T; i++) {
            System.out.println(dp[n[i]]);
        }
    }
}