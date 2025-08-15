import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MOD = 1_000_000;

        String input = br.readLine();
        int[] dp = new int[input.length() + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        if (input.charAt(0) == '0') {
            System.out.println(0);
            return ;
        }
        for (int i = 2; i <= input.length(); i++) {
            int cur = input.charAt(i - 1) - '0';
            int prev = input.charAt(i - 2) - '0';

            if (cur != 0) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }
            if (prev == 1 || (prev == 2 && cur < 7)) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[input.length()]);
    }
}