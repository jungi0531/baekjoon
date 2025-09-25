import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        count = new int[3];
        int N = Integer.parseInt(br.readLine());
        paper = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < N; ii++) {
                paper[i][ii] = Integer.parseInt(st.nextToken());
            }
        }
        //
        div(0, N, 0, N);
        // 출력
        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }
    }
    public static void div(int startRow, int endRow, int startCol, int endCol) {
        // 같은 거만 있는 게 아니면 3등분
        if (!sameColor(startRow, endRow, startCol, endCol)) {
            int size = (endRow - startRow) / 3;
            div(startRow, startRow + size, startCol, startCol + size);
            div(startRow, startRow + size, startCol + size, startCol + size * 2);
            div(startRow, startRow + size, startCol + size * 2, endCol);

            div(startRow + size, startRow + size * 2, startCol, startCol + size);
            div(startRow + size, startRow + size * 2, startCol + size, startCol + size * 2);
            div(startRow + size, startRow + size * 2, startCol + size * 2, endCol);

            div(startRow + size * 2, endRow, startCol, startCol + size);
            div(startRow + size * 2, endRow, startCol + size, startCol + size * 2);
            div(startRow + size * 2, endRow, startCol + size * 2, endCol);
        }
        else {
            int color = paper[startRow][startCol];
            count[color + 1]++;
        }
    }
    public static boolean sameColor(int startRow, int endRow, int startCol, int endCol) {
        int color = paper[startRow][startCol];
        for (int i = startRow; i < endRow; i++) {
            for (int ii = startCol; ii < endCol; ii++) {
                if (color != paper[i][ii]) {
                    return false;
                }
            }
        }
        return true;
    }
}