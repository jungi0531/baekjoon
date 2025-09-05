import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] += Integer.parseInt(st.nextToken());
            arr[i][1] += Integer.parseInt(st.nextToken());
        }
        //
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = 0;
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int ii = 0; ii < N; ii++) {
                if (g >= arr[ii][0] + arr[ii][1] && x <= arr[ii][0] && y <= arr[ii][1])
                    count++;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}