import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer>[] vertices;
    public static int[] state;
    public static boolean[] isCyclic;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 입력
            int n = Integer.parseInt(br.readLine());
            vertices = new ArrayList[n + 1];
            for (int ii = 0; ii <= n; ii++) {
                vertices[ii] = new ArrayList<>();
            }
            state = new int[n + 1];
            isCyclic = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int ii = 1; ii <= n; ii++) {
                vertices[ii].add(Integer.parseInt(st.nextToken()));
            }
            // 그래프 탐색으로 사이클 찾기
            int count = 0;
            for (int ii = 1; ii <= n; ii++) {
                if (state[ii] == 0)
                    dfs(ii);
            }
            // 사이클에 속하지 않는 노드 개수 카운트
            for (int ii = 1; ii <= n; ii++) {
                if (!isCyclic[ii])
                    count++;
            }
            //
            sb.append(String.valueOf(count)).append("\n");
        }
        System.out.println(sb);
    }
    public static int dfs(int start) {
        if (isCyclic[start])
            return 0;
        if (state[start] == 1) {
            isCyclic[start] = true;
            state[start] = 2;
            return start;
        }
        if (state[start] == 2)
            return 0;

        state[start] = 1;
        for (int i = 0; i < vertices[start].size(); i++) {
            int result = dfs(vertices[start].get(i));
            if (result != 0) {
                isCyclic[start] = true;
                if (result == start) {
                    return 0;
                }
                return result;
            }
            state[start] = 2;
        }
        return 0;
    }
}