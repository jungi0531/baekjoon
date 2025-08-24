import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] vertices;
    public static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int count = 0;
            // 입력
            int N = Integer.parseInt(br.readLine());
            vertices = new ArrayList[N + 1];
            for (int ii = 0; ii <= N; ii++) {
                vertices[ii] = new ArrayList<>();
            }
            visited = new boolean[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int ii = 1; ii <= N; ii++) {
                vertices[ii].add(Integer.parseInt(st.nextToken()));
            }
            //
            for (int ii = 1; ii <= N; ii++) {
                if (!visited[ii]) {
                    count++;
                    dfs(ii);
                }
            }
            sb.append(count).append("\n");
        }
        // 출력
        System.out.println(sb);
    }
    public static void dfs(int start) {
        if (visited[start])
            return;
        visited[start] = true;
        for (int i = 0; i < vertices[start].size(); i++) {
            dfs(vertices[start].get(i));
        }
    }
}