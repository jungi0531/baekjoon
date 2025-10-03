import java.io.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        //
        arr = new int[N][2 * N - 1];
        div(0, 0, N, 2 * N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N ; i++) {
            for (int ii = 0; ii < 2 * N - 1; ii++) {
                if (arr[i][ii] == 1) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        // 출력
        System.out.println(sb);
    }
    public static void div(int x, int y, int xSize, int ySize) {
        if (xSize <= 3) {
            arr[x][y + 2] = 1;
            arr[x + 1][y + 1] = 1;
            arr[x + 1][y + 3] = 1;
            for (int i = 0; i < ySize; i++) {
                arr[x + xSize - 1][y + i] = 1;
            }
            return ;
        }
        xSize /= 2;
        ySize /= 2;

        div(x, y + ySize / 2 + 1, xSize, ySize);
        div(x + xSize, y, xSize, ySize);
        div(x + xSize, y + ySize + 1, xSize, ySize);
    }
}