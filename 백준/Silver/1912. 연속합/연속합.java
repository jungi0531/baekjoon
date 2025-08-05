import java.io.*;
import java.util.Arrays;

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
        dp[0] = arr[0];

        // 반복문 돌면서 해당 인덱스 값을 넣는게 이득이면 추가, 아니면 해당 인덱스부터 다시 출발
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }

        // 중 가장 큰 값 출력
        int max = -1000;
        for (int i = 0; i < N; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}
