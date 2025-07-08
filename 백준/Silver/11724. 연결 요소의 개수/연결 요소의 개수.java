import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        boolean[] visited = new boolean[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] edges = br.readLine().split(" ");
            int u = Integer.parseInt(edges[0]);
            int v = Integer.parseInt(edges[1]);
            list[u].add(v);
            list[v].add(u);
        }
        // 이제 탐색하기
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                q.add(i);
                count++;
                while (!q.isEmpty()) {
                    int remove = q.poll();
                    for (int temp : list[remove]) {
                        if (!visited[temp]) {
                            visited[temp] = true;
                            q.add(temp);
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();
    }
}