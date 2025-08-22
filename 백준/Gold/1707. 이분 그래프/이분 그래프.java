import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static List<Integer>[] vertices;
    public static int[] bipartite;
    public static boolean isBip;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            // 각 테스트 케이스 입력
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new boolean[V + 1];
            vertices = new ArrayList[V + 1];
            bipartite = new int[V + 1];
            for (int ii = 0; ii <= V; ii++) {
                bipartite[ii] = -1;
            }
            for (int ii = 0; ii <= V; ii++) {
                vertices[ii] = new ArrayList<>();
            }
            for (int ii = 0; ii < E; ii++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                vertices[v1].add(v2);
                vertices[v2].add(v1);
            }
            //
            isBip = true;
            for (int ii = 1; ii <= V; ii++) {
                if (!visited[ii])
                    dfs(ii, 0);
            }
            //
            if (isBip)
                sb.append("YES");
            else
                sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int start, int prev) {
        if (visited[start]) {
            if (bipartite[start] != -1 && prev == bipartite[start]) {
                isBip = false;
            }
            return;
        }
        if (prev == 0)
            bipartite[start] = 1;
        else
            bipartite[start] = 0;
        visited[start] = true;
        for (int i = 0; i < vertices[start].size(); i++) {
            dfs(vertices[start].get(i), bipartite[start]);
        }
    }
}