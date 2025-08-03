import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // ii 인덱스의 값이 i 인덱스에 있는 값보다 크면 감소하는 수열이 될 수 있으므로
        // ii 인덱스에 i 인덱스의 있는 값을 추가한 길이인 dp[ii] + 1과 현재 dp[i] 값을 비교한다.
        // <- 현재 dp[i] 값에는 이와 같이 전에 비교된 값이 들어있을 수 있음
        for (int i = 1; i < N; i++) {
            for (int ii = 0; ii < i; ii++) {
                if (arr[i] < arr[ii])
                    dp[i] = Math.max(dp[i], dp[ii] + 1);
            }
        }

        // 가장 긴 부분 찾아 출력
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        System.out.println(max + 1);
    }
}