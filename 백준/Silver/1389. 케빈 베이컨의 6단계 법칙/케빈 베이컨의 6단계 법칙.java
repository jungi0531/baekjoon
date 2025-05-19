import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 큐 배열을 통해 입력 받기 ->

        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            if (!list[A].contains(B))
                list[A].add(B);
            if (!list[B].contains(A))
                list[B].add(A);
        }
        // 자기 제외 total 횟수를 구해서 min 값에 저장
        int minCount = Integer.MAX_VALUE;
        int minCountIndex = 0;
        for (int i = 1; i <= N; i++) {
            int count = bfs(i, list, N);
            // BFS로 최단 경로 찾기

            // 최소 값일 경우 변경
            if (count < minCount) {
                minCount = count;
                minCountIndex = i;
            }
        }
        // 정답 출력
        bw.write(String.valueOf(minCountIndex) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int bfs(int start, ArrayList<Integer>[] list, int N) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : list[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        int total = 0;
        for (int i = 1; i <= N; i++) {
            total += dist[i];
        }
        return total;
    }
}