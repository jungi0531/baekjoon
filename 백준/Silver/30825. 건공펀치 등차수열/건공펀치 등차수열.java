import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long count = 0;

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //
        for (int i = 1; i < N; i++) {
            if (arr[i + 1] - arr[i] > K) {
                count += arr[i + 1] - K - arr[i];
                arr[i] = arr[i + 1] - K;
                if (i > 1) {
                    i -= 2;
                    continue;
                }
            }
            if (arr[i + 1] - arr[i] < K) {
                count += arr[i] + K - arr[i + 1];
                arr[i + 1] = arr[i] + K;
            }
        }
        // 출력
        System.out.println(count);
    }
}
