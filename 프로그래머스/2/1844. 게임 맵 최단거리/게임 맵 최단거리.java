import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        // 최단거리니까 BFS로 하고 도착할 수 없으면 -1 리턴
        int answer = 0;
        int[] x = {1, 0, -1, 0};
        int[] y = {0, -1, 0, 1};
        boolean findExit = false;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        answer++;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] remove = q.poll();
                for (int ii = 0; ii < 4; ii++) {
                    int curX = remove[0] + x[ii];
                    int curY = remove[1] + y[ii];
                    
                    if (curX == maps.length - 1 && curY == maps[0].length - 1) {
                        findExit = true;
                        break;
                    }
                    
                    if (0 <= curX && curX < maps.length &&
                        0 <= curY && curY < maps[0].length &&
                        maps[curX][curY] == 1 &&
                        !visited[curX][curY]) {
                        visited[curX][curY] = true;
                        q.add(new int[]{curX, curY});
                    } 
                }
                if (findExit) break;
            }
            answer++;
            if (findExit) break;
        }
        
        if (findExit) return answer;
        return -1;
    }
}