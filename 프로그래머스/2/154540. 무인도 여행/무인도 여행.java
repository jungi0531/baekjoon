import java.util.*;

class Solution {
    static boolean[][] visited;
    static final int[] x = {1, 0, -1, 0};
    static final int[] y = {0, -1, 0, 1};
    
    public int[] solution(String[] maps) {
        // 각 뭉탱이에 있는 수들 다 더해서 배열에 오름차순 정렬 후 리턴
        // 배열을 만드려면 우선 섬의 개수를 세야하나? 굳이?
        // 우선 섬의 식량 양을 PriorityQueue에 넣어놓고 해당 크기의 배열을 만들고 순서대로 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) {
            for (int ii = 0; ii < maps[0].length(); ii++) {
                if (!visited[i][ii] && maps[i].charAt(ii) != 'X') {
                    pq.add(bfs(maps, i, ii));
                }
            }
        }
        
        if (pq.size() == 0) return (new int[]{-1});
        int[] answer = new int[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }
        
        return answer;
    }
    public int bfs(String[] maps, int row, int col) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{row, col});
        visited[row][col] = true;
        count += maps[row].charAt(col) - '0';
        
        while (!q.isEmpty()) {
            int[] remove = q.poll();
            for (int i = 0; i < 4; i++) {
                int curX = remove[0] + x[i];
                int curY = remove[1] + y[i];
                if (0 <= curX && curX < maps.length &&
                    0 <= curY && curY < maps[0].length() &&
                    maps[curX].charAt(curY) != 'X' &&
                    !visited[curX][curY]) {
                    visited[curX][curY] = true;
                    count += maps[curX].charAt(curY) - '0';
                    q.add(new int[]{curX, curY});
                }
            }
        }

        return count;
    }
}