import java.util.*;

class Solution {
    static final int[] x = {1, 0, -1, 0};
    static final int[] y = {0, -1, 0, 1};
    static int[] result;
    
    public int solution(int[][] land) {
        int answer = 0;
        result = new int[land[0].length];
        boolean[][] visited = new boolean[land.length][land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            for (int ii = 0; ii < land[0].length; ii++) {
                if (!visited[i][ii] && land[i][ii] == 1) {
                    bfs(land, visited, i, ii);
                }
            }
        }
        
        for (int i = 0; i < result.length; i++) {
            answer = Math.max(answer, result[i]);
        }
        
        return answer;
    }
    public void bfs(int[][] land, boolean[][] visited, int row, int col) {
        // 현재 덩어리의 크기를 구하고 해당 덩어리가 포함되는 열에 덩어리 크기 더하기
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        HashSet<Integer> hash = new HashSet<>();
        
        q.add(new int[]{row, col});
        visited[row][col] = true;
        count++;
        hash.add(col);
        
        while (!q.isEmpty()) {
            int[] remove = q.poll();
            for (int i = 0; i < 4; i++) {
                int curX = remove[1] + x[i];
                int curY = remove[0] + y[i];
                if (0 <= curX && curX < land[0].length &&
                    0 <= curY && curY < land.length &&
                    !visited[curY][curX] && land[curY][curX] == 1) {
                    q.add(new int[]{curY, curX});
                    count++;
                    visited[curY][curX] = true;
                    hash.add(curX);
                }
            }
        }
        
        for (int i : hash) {
            result[i] += count;
        }
    }
}