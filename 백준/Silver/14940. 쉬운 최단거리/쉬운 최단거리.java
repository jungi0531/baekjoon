import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int startN;
    static int startM;

    public static void main(String[] args) throws IOException {
        getInput();
        //
        bfs();
        //
        printResult();
    }
    public static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        startN = -1;
        startM = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < m; ii++) {
                map[i][ii] = Integer.parseInt(st.nextToken());
                if (map[i][ii] == 2) {
                    startN = i;
                    startM = ii;
                }
            }
        }
    }
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[] moveX = {1, -1, 0, 0};
        int[] moveY = {0, 0, 1, -1};
        int distance = 1;

        q.add(new int[]{startN, startM});
        visited[startN][startM] = true;
        map[startN][startM] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] remove = q.poll();
                for (int ii = 0; ii < 4; ii++) {
                    int x = remove[0] + moveX[ii];
                    int y = remove[1] + moveY[ii];
                    if (0 <= x && x < n && 0 <= y && y < m) {
                        if (!visited[x][y] && map[x][y] != 0) {
                            visited[x][y] = true;
                            map[x][y] = distance;
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
            distance++;
        }
    }
    public static void printResult() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < m; ii++) {
                if (!visited[i][ii] && map[i][ii] != 0) map[i][ii] = -1;
                bw.write(String.valueOf(map[i][ii]) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}