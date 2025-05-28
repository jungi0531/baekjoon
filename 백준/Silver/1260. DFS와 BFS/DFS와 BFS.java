import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] list;
    static String[] num;
    static String[] input;
    static int N;
    static int M;
    static int V;
    static int node1;
    static int node2;
    static boolean[] visited;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        initGraph();
        dfs(V);
        Arrays.fill(visited, false);
        result.append("\n");
        bfs(V);
        printResult();
    }
    public static void initGraph() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = br.readLine().split(" ");
        N = Integer.parseInt(num[0]);
        M = Integer.parseInt(num[1]);
        V = Integer.parseInt(num[2]);
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            list[node1].add(node2);
            list[node2].add(node1);
        }
        for (int i = 0; i <= N; i++) {
            list[i].sort(null);
        }
        br.close();
    }
    public static void dfs(int cur) {
        if (visited[cur])
            return;
        visited[cur] = true;
        result.append(cur).append(" ");
        for (int i = 0; i < list[cur].size(); i++) {
            dfs(list[cur].get(i));
        }
//        while (!list[cur].isEmpty()) {
//            dfs(list[cur].removeFirst());
//        }
    }
    public static void bfs(int cur) {
        Queue<Integer> q = new LinkedList<>();

        q.add(cur);
        visited[cur] = true;
        result.append(cur).append(" ");
        while (!q.isEmpty()) {
            int remove = q.poll();
            for (int i = 0; i < list[remove].size(); i++) {
                int curIndex = list[remove].get(i);
                if (!visited[curIndex]) {
                    visited[curIndex] = true;
                    q.add(curIndex);
                    result.append(curIndex).append(" ");
                }
            }
        }
    }
    public static void printResult() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result.toString() + "\n");
        bw.flush();
        bw.close();
    }
}