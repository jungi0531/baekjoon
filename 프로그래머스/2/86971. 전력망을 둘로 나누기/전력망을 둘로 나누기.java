import java.util.*;

class Solution {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int count;
    static int min;
    
    public int solution(int n, int[][] wires) {
        // 최대한 비슷하게 나눠지는 곳 찾기
        // 할 때마다 하나씩 빼고 만들어서 절대값이 가장 작은 값을 저장해놓기
        arr = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            count = 0;
            visited = new boolean[n + 1];
            // i 빼고 만들고
            for (int ii = 0; ii <= n; ii++) {
                arr[ii] = new ArrayList<>();
            }
            for (int ii = 0; ii < wires.length; ii++) {
                if (i == ii) continue;
                arr[wires[ii][0]].add(wires[ii][1]);
                arr[wires[ii][1]].add(wires[ii][0]);
            }
            // 돌면서 두 뭉티의 차이 세기.
            dfs(1);
            //System.out.println(count);
            min = Math.min(min, Math.abs((n - count) - count));
        }
        
        return min;
    }
    public void dfs(int cur) {
        visited[cur] = true;
        count++;
        
        for (int i = 0; i < arr[cur].size(); i++) {
            int num = arr[cur].get(i);
            if (!visited[num]) {
                dfs(num);
            }
        }
    }
}