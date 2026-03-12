import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    
    public int solution(int n, int[][] computers) {
        // 이어진 그래프 세기
        int answer = 0;
        visited = new boolean[n];
        
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                if (computers[i][ii] == 1) {
                    arr[i].add(ii);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        
        return answer;
    }
    public void dfs(int cur) {
        visited[cur] = true;
        
        for (int i = 0; i < arr[cur].size(); i++) {
            if (!visited[arr[cur].get(i)]) {
                dfs(arr[cur].get(i));
            }
        }
    }
}