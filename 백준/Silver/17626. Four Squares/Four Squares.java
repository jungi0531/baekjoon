import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        // 그러니까 dp로 풀려면 n = min((n 값), (n - (i * i) 값) -> i * i는 1, 4, 9, 16... 이전 제곱 수 전 인덱스
        // 이전 값 vs 현재 인덱스에서 모든 제곱 수 뺀 인덱스 값 중 최소로 결정
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 우선 나올 수 없는 최대값 넣기
            dp[i] = i;
            for (int ii = 1; ii * ii <= i; ii++) {
                // 현재 최대 값과, n - 1, n - 4, n - 9 등 제곱 수 전 값의 +1 한 값 중 최소 값 dp[i]에 넣기
                dp[i] = Math.min(dp[i], dp[i - (ii * ii)] + 1);
            }
        }
        bw.write(String.valueOf(dp[n]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}