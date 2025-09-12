import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K + 1];
        long right = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i], right);
        }
        //
        long left = 1;
        long result = 0;
        while (left <= right) {
            long count = 0;
            long mid = (left + right) / 2;
            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
            }
            if (count < N) {
                // 길이 줄이기
                right = mid - 1;
            }
            else {
                // 길이 늘리기
                left = mid + 1;
                if (result < mid) result = mid;
            }
        }
        // 출력
        System.out.println(result);
    }
}