import java.io.*;
import java.util.*;

public class Main {
    static int w;
    static int h;
    static int[][] arr;
    static boolean[][] visited;
    static boolean inLand;
    static int[] xIndex = {1, 0, -1, 1, -1, 1, 0, -1};
    static int[] yIndex = {1, 1, 1, 0, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            // 입력
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0)
                break;
            arr = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int ii = 0; ii < w; ii++) {
                    arr[i][ii] = Integer.parseInt(st.nextToken());
                }

            }
            //
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int ii = 0; ii < w; ii++) {
                    if (!visited[i][ii]) {
                        inLand = false;
                        dfs(i, ii);
                        if (inLand)
                            count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        // 출력
        System.out.println(sb);
    }
    public static void dfs(int x, int y) {
        if (visited[x][y])
            return ;
        visited[x][y] = true;
        if (arr[x][y] == 1) {
            if (!inLand) {
                inLand = true;
            }
            for (int i = 0; i < 8; i++) {
                if (0 <= x + xIndex[i] && x + xIndex[i] < h) {
                    if (0 <= y + yIndex[i] && y + yIndex[i] < w) {
                        dfs(x + xIndex[i], y + yIndex[i]);
                    }
                }
            }
        }
    }
}