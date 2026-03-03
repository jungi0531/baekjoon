class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        int d = 0;
        
        for (char c : dirs.toCharArray()) {
            if (c == 'U') d = 0;
            if (c == 'R') d = 1;
            if (c == 'D') d = 2;
            if (c == 'L') d = 3;
            
            int curX = x + dx[d];
            int curY = y + dy[d];
            if (0 <= curX && curX < 11 &&
                0 <= curY && curY < 11) {
                if (!visited[y][x][d]) {
                    visited[y][x][d] = true;
                    visited[curY][curX][(d + 2) % 4] = true;
                    answer++;
                }
                x = curX;
                y = curY;
            }
        }
        
        return answer;
    }
}