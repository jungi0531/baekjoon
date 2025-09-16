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
            if (bs(arr, target)) sb.append("1 ");
            else sb.append("0 ");
        }
        // 출력
        System.out.println(sb);
    }
    public static boolean bs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}