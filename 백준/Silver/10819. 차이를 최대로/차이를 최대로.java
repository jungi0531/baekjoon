import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int[] selected;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        selected = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //
        dfs(0);
        //
        System.out.println(result);
    }
    public static void dfs(int count) {
        if (count == N) {
            result = Math.max(result, getSum());
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[count] = arr[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }
    public static int getSum() {
        int sum = 0;

        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(selected[i] - selected[i + 1]);
        }
        return sum;
    }
}