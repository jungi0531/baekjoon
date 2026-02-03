import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        // 그냥 간선 하나 끊고 노드 하나 잡고 끝까지 count하고 n과 비교
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            graph = new ArrayList[n + 1];
            for (int ii = 0; ii <= n; ii++) {
                graph[ii] = new ArrayList<>();
            }
            
            for (int ii = 0; ii < wires.length; ii++) {
                if (i == ii) continue;
                
                int a = wires[ii][0];
                int b = wires[ii][1];
                graph[a].add(b);
                graph[b].add(a);
            }
            int count = bfs(n);
            
            answer = Math.min(answer, Math.abs(Math.abs(n - count) - count));
        }
        
        return answer;
    }
    public int bfs(int n) {
        int count = 0; // 노드 1 넣고 노드 1과 연결된 노드 개수 세기
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        q.add(1);
        visited[1] = true;
        count++;
        while (!q.isEmpty()) {
            int remove = q.poll();
            for (int i = 0; i < graph[remove].size(); i++) {
                int temp = graph[remove].get(i);
                if (!visited[temp]) {
                    visited[temp] = true;
                    count++;
                    q.add(temp);
                }
            }
        }
        
        return count;
    }
}