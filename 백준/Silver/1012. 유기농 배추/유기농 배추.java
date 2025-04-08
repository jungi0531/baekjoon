import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 입력 받기
            String[] input = br.readLine().split(" ");
            int M = Integer.parseInt(input[0]); // 가로 길이
            int N = Integer.parseInt(input[1]); // 세로 길이
            int K = Integer.parseInt(input[2]); // 배추 개수
            int[][] grid = new int[M][N];   // 배추 위치 체크
            for (int ii = 0; ii < K; ii++) {
                String[] cabbagePosition = br.readLine().split(" ");
                int X = Integer.parseInt(cabbagePosition[0]);
                int Y = Integer.parseInt(cabbagePosition[1]);
                // 이차원 배열에 배추 위치 1로 표시
                grid[X][Y] = 1;
            }
            // 이차원 배열을 돌면서 필요 지렁이 수 카운트 하기
            // 카운트 방법
            int count = 0;  // 정답인 지렁이 마리 수
            boolean[][] visited = new boolean[M][N];    // 해당 배추 클러스터 지렁이가 있는지(boolean 초기값 false)
            for (int j = 0; j < M; j++) {
                for (int jj = 0; jj < N; jj++) {
                    if (grid[j][jj] == 1 && !visited[j][jj]) {
                        // 만약 해당 배추 클러스터에 지렁이가 아직 없다면
                        // 지렁이 수++ 하고 해당 클러스터 모든 배추 위치 visited true
                        recur(grid, visited, j, jj);    // 해당 배추 클러스터 visited 값 true로 변경
                        count++;
                    }
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void recur(int[][] grid, boolean[][] visited, int x, int y) {
        // 배추 자리 아니거나 이미 체크 했으면 뒤로
        if (grid[x][y] == 0 || visited[x][y])
            return;
        // 해당 자리가 배추이고 지렁이 체크 안 했으니 체크
        visited[x][y] = true;
        // 상하좌우 인근 배추 탐색
        int[] xCoor = {1, 0, -1, 0};
        int[] yCoor = {0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            // 조건문으로 적절한 인덱스인지 확인 후 재귀 탐색
            if (0 <= x + xCoor[i] && x + xCoor[i] <= grid.length - 1) {
                if (0 <= y + yCoor[i] && y + yCoor[i] <= grid[0].length - 1) {
                    recur(grid, visited, x + xCoor[i], y + yCoor[i]);
                }
            }
        }
    }
}