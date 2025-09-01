import java.io.*;
import java.util.*;

public class Main {
    static int count;
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static boolean inGroup;
    static int[] xIndex = {0, 0, 1, -1};
    static int[] yIndex = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> group = new ArrayList<>();

        // 입력
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int ii = 0; ii < N; ii++) {
                arr[i][ii] = input.charAt(ii) - '0';
            }
        }
        //
        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < N; ii++) {
                inGroup = false;
                dfs(i, ii);
                if (inGroup) {
                    group.add(count);
                    count = 0;
                }
            }
        }
        // 출력
        Collections.sort(group);
        StringBuilder sb = new StringBuilder();
        sb.append(group.size()).append("\n");
        for (int i = 0; i < group.size(); i++) {
            sb.append(group.get(i)).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int x, int y) {
        if (visited[x][y])
            return;
        visited[x][y] = true;
        if (arr[x][y] == 1) {
            if (!inGroup)
                inGroup = true;
            for (int i = 0; i < 4; i++) {
                if (0 <= x + xIndex[i] && x + xIndex[i] < N) {
                    if (0 <= y + yIndex[i] && y + yIndex[i] < N) {
                        dfs(x + xIndex[i], y + yIndex[i]);
                    }
                }
            }
            count++;
        }
    }
}