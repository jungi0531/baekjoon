import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int start;
    static boolean[] visited;
    static int[] path;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];
        path = new int[N * N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < N; ii++) {
                arr[i][ii] = Integer.parseInt(st.nextToken());
            }
        }
        //
        for (int i = 0; i < N; i++) {
            start = i;
            dfs(i, 0);
        }
        //
        System.out.println(result);
    }
    public static void dfs(int cur, int count) {
        if (check(cur)) {
            result = Math.min(result, getResult(count));
            return;
        }

        for (int i = 0; i < N; i++) {
            // 자기 자신의 길이거나 길이 없지 않은 경우
            if (!visited[i] && arr[cur][i] != 0) {
                visited[i] = true;
                path[count] = arr[cur][i];
                dfs(i, count + 1);
                visited[i] = false;
            }
        }
    }
    public static boolean check(int cur) {
        for (int i = 0 ; i < N; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        if (cur != start) {
            return false;
        }

        return true;
    }
    public static int getResult(int count) {
        int sum = 0;

        for (int i = 0; i < count; i++) {
            sum += path[i];
        }
        return sum;
    }
}