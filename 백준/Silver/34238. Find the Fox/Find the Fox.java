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
        int[][] map = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int ii = 0; ii < M; ii++) {
                if (input.charAt(ii) == 'F')
                    map[i][ii] = 1;
                else if (input.charAt(ii) == 'O')
                    map[i][ii] = 2;
                else
                    map[i][ii] = 3;
            }
        }
        //
        int count = 0;
        int[] xIndex = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] yIndex = {1, 0, -1, -1, -1, 0, 1, 1};
        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < M; ii++) {
                // 현재 인덱스가 F면 각 방향 FOX 찾기
                if (map[i][ii] == 1) {
                    for (int iii = 0; iii < 8; iii++) {
                        int x = i +  2 * xIndex[iii];
                        int y = ii + 2 * yIndex[iii];
                        if (0 <= x && x < N && 0 <= y && y < M) {
                            if (map[x - xIndex[iii]][y - yIndex[iii]] == 2) {
                                if (map[x][y] == 3) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        // 출력
        System.out.println(count);
    }
}