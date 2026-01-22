import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int[] x = {1, 0, -1, 0};
        int[] y = {0, -1 ,0, 1};
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        
        // 미로 출구 찾기는 DFS인데 최단 경로는 BFS
        // 우선 시작 지점 -> 레버로 가는 최단 경로 수 + 레버 -> 출구까지 경로 수를 합치기
        Queue<int[]> q = new LinkedList<>();
        
        // S 찾아서 해당 위치 큐에 넣고 시작
        for (int i = 0; i < maps.length; i++) {
            for (int ii = 0; ii < maps[0].length(); ii++) {
                if (maps[i].charAt(ii) == 'S') {
                    q.add(new int[]{i, ii});
                }
            }
        }
        // System.out.println(q.peek()[0] + " " + q.peek()[1]);
        
        // 시작점에서 레버
        boolean isLever = false;
        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] remove = q.poll();
                for (int ii = 0; ii < 4; ii++) {
                    int curX = remove[0] + x[ii];
                    int curY = remove[1] + y[ii];
                    if (0 <= curX && curX < maps.length && 
                        0 <= curY && curY < maps[0].length() && 
                        !visited[curX][curY]) {
                        if (maps[curX].charAt(curY) == 'L') {
                            isLever = true;
                            q.clear();
                            q.add(new int[]{curX, curY});
                            visited = new boolean[maps.length][maps[0].length()];
                            break;
                        }
                        else if (maps[curX].charAt(curY) != 'X') {
                            q.add(new int[]{curX, curY});
                            visited[curX][curY] = true;
                        }
                    }
                }
                if (isLever) break;
            }
            answer++;
            if (isLever) break;
            if (answer > 10000) return -1;
        }
        // 레버에서 출구
        boolean isExit = false;
        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] remove = q.poll();
                for (int ii = 0; ii < 4; ii++) {
                    int curX = remove[0] + x[ii];
                    int curY = remove[1] + y[ii];
                    if (0 <= curX && curX < maps.length && 
                        0 <= curY && curY < maps[0].length() &&
                        !visited[curX][curY]) {
                        if (maps[curX].charAt(curY) == 'E') {
                            isExit = true;
                            break;
                        }
                        else if (maps[curX].charAt(curY) != 'X') {
                            q.add(new int[]{curX, curY});
                            visited[curX][curY] = true;
                        }
                    }
                }
                if (isExit) break;

            }
            answer++;
            if (isExit) break;
            if (answer > 10000) return -1;
        }
        
        return answer;
    }
}