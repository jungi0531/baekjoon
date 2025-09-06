import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] visited;
    static int landNum;
    static int[] xIndex = {0, 0, 1, -1};
    static int[] yIndex = {1, -1, 0, 0};
    static int minLength;
    static int bfsId = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < N; ii++) {
                map[i][ii] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 구분해놓기
        visited = new int[N + 1][N + 1];
        landNum = 1;
        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < N; ii++) {
                if (visited[i][ii] == 0 && map[i][ii] == 1) {
                    dfs(i, ii);
                    landNum++;
                }
            }
        }
        // 한 섬에서 다른 섬으로 가는 최단 다리 각 섬마다 측정
        // 각 섬의 edge에서 bfs 출발 후 다른 섬을 닿는 최단 거리 측정
        visited = new int[N + 1][N + 1];
        minLength = 300;
        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < N; ii++) {
                if (map[i][ii] != 0 && visited[i][ii] == 0) {
                    findEdgeDfs(i, ii);
                }
            }
        }
        // 출력
        System.out.println(minLength);
    }
    public static void dfs(int x, int y) {
        visited[x][y] = 1;
        map[x][y] = landNum;
        for (int i = 0; i < 4; i++) {
            int tempX = x + xIndex[i];
            int tempY = y + yIndex[i];
            if (0 <= tempX && tempX < N && 0 <= tempY && tempY < N) {
                if (visited[tempX][tempY] == 0 && map[tempX][tempY] == 1)
                    dfs(tempX, tempY);
            }
        }
    }
    public static void findEdgeDfs(int x, int y) {
        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int tempX = x + xIndex[i];
            int tempY = y + yIndex[i];
            if (0 <= tempX && tempX < N && 0 <= tempY && tempY < N) {
                if (map[tempX][tempY] == 0) {
                    findBridgeBfs(tempX, tempY, map[x][y]);
                }
                else if (visited[tempX][tempY] == 0) {
                    findEdgeDfs(tempX, tempY);
                }
            }
        }
    }
    public static void findBridgeBfs(int x, int y, int curLand) {
        Queue<int[]> q = new LinkedList<>();
        int count = 1;
        bfsId++;

        visited[x][y] = bfsId;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] remove = q.poll();
                for (int ii = 0; ii < 4; ii++ ) {
                    int tempX = remove[0] + xIndex[ii];
                    int tempY = remove[1] + yIndex[ii];
                    if (0 <= tempX && tempX < N && 0 <= tempY && tempY < N) {
                        if (visited[tempX][tempY] != bfsId && map[tempX][tempY] == 0) {
                            visited[tempX][tempY] = bfsId;
                            q.add(new int[]{tempX, tempY});
                        }
                        else if (map[tempX][tempY] != 0 && map[tempX][tempY] != curLand) {
                            if (count < minLength) {
                                minLength = count;
                                return;
                            }
                        }
                    }
                }
            }
            count++;
        }
    }
}