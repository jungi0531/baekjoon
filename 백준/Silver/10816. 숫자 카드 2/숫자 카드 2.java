import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        // bs
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int count = bsUpper(arr, target) - bsLower(arr, target) + 1;
            sb.append(String.valueOf(count)).append(" ");
        }
        // 출력
        System.out.println(sb);
    }
    public static int bsLower(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] >= target) end = mid - 1;
            else start = mid + 1;
        }

        return start;
    }
    public static int bsUpper(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;

            if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return end;
    }
}