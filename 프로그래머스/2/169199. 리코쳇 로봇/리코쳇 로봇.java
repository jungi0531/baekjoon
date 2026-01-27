import java.util.*;

class Solution {
    public int solution(String[] board) {
        // 우선 R이 있는 곳을 찾아서 해당 위치를 Queue에 넣고 시작
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length()];
        int[] x = new int[]{1, 0, -1, 0};
        int[] y = new int[]{0, -1, 0, 1};
        
        for (int i = 0; i < board.length; i++) {
            for (int ii = 0; ii < board[0].length(); ii++) {
                if (board[i].charAt(ii) == 'R') {
                    q.add(new int[]{i, ii});
                    visited[i][ii] = true;
                }
            }
        }
        // 여까진 OK
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] remove = q.poll();
                // 여기서부터 시작 상하좌우 가보기 visited 확인하고
                for (int ii = 0; ii < 4; ii++) {
                    // 이 curX를 벽이나 경계 닿기 전까지 땡기는 게 포인트
                    // 이 전에도 확인을 해야하나?
                    int distance = 0;
                    if (x[ii] != 0) {
                        while (true) {
                            int temp = remove[0] + (x[ii] * (distance + 1));
                            if (0 > temp || temp >= board.length || 
                                board[temp].charAt(remove[1]) == 'D') {
                                break;
                            }
                            distance++;
                        }
                    } else {
                        while (true) {
                            int temp = remove[1] + (y[ii] * (distance + 1));
                            if (0 > temp || temp >= board[0].length() || 
                                board[remove[0]].charAt(temp) == 'D') {
                                break;
                            }
                            distance++;
                        }
                    }
                    int curX = remove[0] + (x[ii] * distance);
                    int curY = remove[1] + (y[ii] * distance);
                    
                    // 이거 전에 범위 확인
                    if (0 <= curX && curX < board.length && 
                        0 <= curY && curY < board[0].length() && 
                        !visited[curX][curY]) {
                        if (board[curX].charAt(curY) == 'G') {
                            return count + 1;
                        }
                        else {
                            visited[curX][curY] = true;
                            q.add(new int[]{curX, curY});
                            System.out.println(curX + " " + curY);
                        }
                    }
                }
            }
            count++;
            System.out.println();
        }
        
        // 이후 BFS로 진행하는데 한 칸씩 이동이 아닌 아오오니 자일리톨 오니처럼 이동
        return -1;
    }
}