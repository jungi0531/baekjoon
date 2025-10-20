import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //
        Arrays.sort(arr);
        int min = arr[0];
        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
            min += arr[i];
        }
        // 출력
        System.out.println(min);
    }
}