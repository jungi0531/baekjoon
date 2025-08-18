import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] vertex;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        vertex = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            vertex[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            vertex[v1].add(v2);
            vertex[v2].add(v1);
        }
        for (int i = 0; i <= N; i++) {
            vertex[i].sort(null);
        }

        // 탐색
        dfs(V);
        bw.write("\n");
        Arrays.fill(visited, false);
        bfs(V);
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
    public static void dfs(int start) throws IOException {
        if (visited[start])
            return;
        bw.write(String.valueOf(start) + " ");
        visited[start] = true;
        for (int i = 0; i < vertex[start].size(); i++) {
            dfs(vertex[start].get(i));
        }
    }
    public static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        bw.write(String.valueOf(start) + " ");
        while (!q.isEmpty()) {
            int remove = q.poll();
            for (int i = 0; i < vertex[remove].size(); i++) {
                int temp = vertex[remove].get(i);
                if (!visited[temp]) {
                    q.add(temp);
                    bw.write(String.valueOf(temp) + " ");
                    visited[temp] = true;
                }
            }
        }
    }
}