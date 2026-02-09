import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    
    public int solution(int n, int[][] computers) {
        // 뭐야 그래프 탐색에 그냥 몇 뭉티 있는지 세는 거 아녀?
        // ArrayList에 추가해놓고 계속 돌기
        int answer = 0;
        visited = new boolean[n];
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                if (computers[i][ii] == 1 && i != ii) {
                    arr[i].add(ii);
                    arr[ii].add(i);
                }
            }
        }
        
        // 여기서 탐색해야하네..
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 여기서 다 visitied로 바꾸기
                dfs(i, n);
                answer++;
            }
        }
        
        return answer;
    }
    public void dfs(int cur, int n) {
        visited[cur] = true;
        
        for (int next : arr[cur]) {
            if (visited[next] == false) {
                dfs(next, n);
            }
        }
        
    }
}