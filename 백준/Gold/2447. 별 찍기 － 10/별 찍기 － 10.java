import java.io.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        //
        arr = new int[N][N];
        div(0, N, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < N; ii++) {
                if (arr[i][ii] == 1) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        // 출력
        System.out.println(sb);
    }
    public static void div(int startX, int endX, int startY, int endY) {
        int size = (endX - startX) / 3;
        if (size <= 1) {
            for (int i = startX; i < endX; i++) {
                for (int ii = startY; ii < endY; ii++) {
                    if (!(i == startX + size && ii == startY + size))
                        arr[i][ii] = 1;
                }
            }
            return;
        }

        div(startX, startX + size, startY, startY + size);
        div(startX + size, startX + 2 * size, startY, startY + size);
        div(startX + 2 * size, endX, startY, startY + size);

        div(startX, startX + size, startY + size, startY + 2 * size);
        // 중앙 비우기
        div(startX + 2 * size, endX, startY + size, startY + 2 * size);

        div(startX, startX + size, startY + 2 * size, endY);
        div(startX + size, startX + 2 * size, startY + 2 * size, endY);
        div(startX + 2 * size, endX, startY + 2 * size, endY);
    }
}