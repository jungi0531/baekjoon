import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N + 1][M + 1];
        boolean[][] visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int ii = 1; ii <= M; ii++) {
                maze[i][ii] = Integer.parseInt(Character.toString(input.charAt(ii - 1)));
            }
        }
        // bfs
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1});
        visited[1][1] = true;
        int[] xIndex = {0, 0, 1, -1};
        int[] yIndex = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] remove = q.poll();
                if (remove[0] == N && remove[1] == M) {
                    q.clear();
                    break;
                }
                for (int ii = 0; ii < 4; ii++) {
                    int x = remove[0] + xIndex[ii];
                    int y = remove[1] + yIndex[ii];
                    if ((0 < x && x <= N) && (0 < y && y <= M) && (maze[x][y] == 1) && (!visited[x][y])) {
                        q.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            count++;
        }
        // 출력
        System.out.println(count);
    }
}