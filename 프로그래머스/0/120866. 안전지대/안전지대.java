class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[] x = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] y = {1, 0, -1, -1, -1, 0, 1, 1};
        
        // 우선 지뢰가 있는 1을 찾아서 그 칸과 거리가 1인 칸을 모두 1로
        for (int i = 0; i < board[0].length; i++) {
            for (int ii = 0; ii < board.length; ii++) {
                if (board[i][ii] == 1) {
                    visited[i][ii] = true;
                    // 사방으로 valid 한 칸은 다 1로 변경 후 visited는 true
                    for (int iii = 0; iii < 8; iii++) {
                        int curX = x[iii] + i;
                        int curY = y[iii] + ii;
                        // 1이면 visited ㄴㄴ
                        if (0 <= curX && curX < board[0].length) {
                            if (0 <= curY && curY < board.length) {
                                if (board[curX][curY] == 0) {
                                    visited[curX][curY] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        // 이때 해당 지뢰 및 1로 바꾼 모든 칸을 visited 상태로 만들기
        
        // 이걸 반복 후 마지막에 다시 이차원 배열을 돌며 0의 개수 세기
        for (int i = 0; i < board[0].length; i++) {
            for (int ii = 0; ii < board.length; ii++) {
                if (visited[i][ii] == false) answer++;
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            for (int ii = 0; ii < board.length; ii++) {
                System.out.print(visited[i][ii] + " ");
            }
            System.out.println();
        }
        
        
        return answer;
    }
}