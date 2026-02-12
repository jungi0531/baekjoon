import java.util.*;

class Solution {
    static int[] result;
    static boolean[][] visited;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1, 0 ,1};
    
    public int solution(int[][] land) {
        int answer = 0;
        result = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];
        
        for (int i = 0; i < land[0].length; i++) {
            searchCol(land, i);
        }
        for (int i = 0; i < land[0].length; i++) {
            // System.out.println(result[i]);
            answer = Math.max(answer, result[i]);
        }
        
        return answer;
    }
    public void searchCol(int[][] land, int col) {
        // 덩어리를 찾아도 그냥 방문처리만 하고 말고 덩어리 크기를 구해놓은 뒤
        // 해당 덩어리가 있는 col에 해당 덩어리의 크기를 모두 더해야 함
        for (int i = 0; i < land.length; i++) {
            if (!visited[i][col] && land[i][col] == 1) {
                bfs(land, i, col);
            }
        }
    }
    public void bfs(int[][] land, int row, int col) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        HashSet<Integer> hash = new HashSet<>();
        
        visited[row][col] = true;
        count++;
        q.add(new int[]{row, col});
        hash.add(col);
        
        while (!q.isEmpty()) {
            int[] remove = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = remove[1] + dx[i];
                int y = remove[0] + dy[i];
                if (0 <= x && x < land[0].length &&
                    0 <= y && y < land.length &&
                    !visited[y][x] && land[y][x] == 1) {
                    visited[y][x] = true;
                    count++;
                    q.add(new int[]{y, x});
                    hash.add(x);
                }
            }
        }
        for (int i : hash) {
            result[i] += count;
        }
    }
}