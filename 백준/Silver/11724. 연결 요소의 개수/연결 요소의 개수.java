import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int count;
    static boolean connected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list[v1].add(v2);
            list[v2].add(v1);
        }
        //
        for (int i = 1; i <= N; i++) {
            connected = false;
            dfs(i);
        }

        // 출력
        System.out.println(count);
    }
    public static void dfs(int start) {
        if (visited[start])
            return;
        visited[start] = true;
        if (!connected) {
            count++;
            connected = true;
        }
        for (int i = 0; i < list[start].size(); i++) {
            dfs(list[start].get(i));
        }
    }
}