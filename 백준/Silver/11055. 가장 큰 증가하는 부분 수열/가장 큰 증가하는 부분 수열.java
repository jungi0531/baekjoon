import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            dp[i] = arr[i];
        }

        for (int i = 1; i < N; i++) {
            for (int ii = 0; ii < i; ii++) {
                if (arr[i] > arr[ii]) {
                    dp[i] = Math.max(dp[i], dp[ii] + arr[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}