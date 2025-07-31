import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int ii = 0; ii <= i; ii++) {
                if (arr[ii] < arr[i] && max < dp[ii] + 1)
                    max = dp[ii] + 1;
            }
            dp[i] = max;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > max)
                max = dp[i];
        }
        System.out.println(max + 1);
    }
}