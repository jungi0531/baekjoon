import java.io.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        //
        arr = new int[N][N];
        div(0, 0, N);

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
    public static void div(int x, int y, int size) {
        if (size <= 1) {
            arr[x][y] = 1;
            return;
        }
        size /= 3;
        for (int i = 0; i < 3; i++) {
            for (int ii = 0; ii < 3; ii++) {
                if (i == 1 && ii == 1) continue;
                div(x + i * size, y + ii * size, size);
            }
        }
    }
}