import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < N; ii++) {
                arr[i][ii] = Integer.parseInt(st.nextToken());
            }
        }
        //
        visited[0] = true;
        dfs(0, 1, 0);
        //
        System.out.println(result);
    }
    public static void dfs(int cur, int count, int cost) {
        if (cost >= result) return;

        if (count == N && arr[cur][0] != 0) {
            result = Math.min(result, cost + arr[cur][0]);
            return;
        }

        for (int i = 0; i < N; i++) {
            // 자기 자신의 길이거나 길이 없지 않은 경우
            if (!visited[i] && arr[cur][i] != 0) {
                visited[i] = true;
                dfs(i, count + 1, cost + arr[cur][i]);
                visited[i] = false;
            }
        }
    }
}