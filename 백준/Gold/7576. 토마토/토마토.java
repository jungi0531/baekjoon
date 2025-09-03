import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] box;
    static boolean[][] visited;
    static int[] xIndex = {0, 0, 1, -1};
    static int[] yIndex = {1, -1, 0 ,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;

        // 입력
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < M; ii++) {
                box[i][ii] = Integer.parseInt(st.nextToken());
            }
        }
        // bfs
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < M; ii++) {
                if (box[i][ii] == 1) {
                    q.add(new int[]{i, ii});
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int ii = 0; ii < size; ii++) {
                int[] remove = q.poll();
                for (int i = 0; i < 4; i++) {
                    int x = remove[0] + xIndex[i];
                    int y = remove[1] + yIndex[i];
                    if (0 <= x && x < N) {
                        if (0 <= y && y < M) {
                            if (box[x][y] == 0) {
                                q.add(new int[]{x, y});
                                box[x][y] = 1;
                            }
                        }
                    }
                }
            }
            count++;
        }
        // 출력
        if (checkBox())
            System.out.println(count - 1);
        else
            System.out.println(-1);
    }
    public static boolean checkBox() {
        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < M; ii++) {
                if (box[i][ii] == 0)
                    return false;
            }
        }
        return true;
    }
}