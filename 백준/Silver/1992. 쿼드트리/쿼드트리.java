import java.io.*;

public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int ii = 0; ii < N; ii++) {
                arr[i][ii] = input.charAt(ii) - '0';
            }
        }
        // 함수를 통해 분할 정복
        div(0, N, 0, N);
        // 출력
        System.out.println(sb);
    }
    public static void div(int startX, int endX, int startY, int endY) {
        if (isAllSame(startX, endX, startY, endY)) {
            sb.append(arr[startX][startY]);
        }
        else {
            sb.append("(");
            int size = (endX - startX) / 2;
            div(startX, startX + size, startY, startY + size);
            div(startX, startX + size, startY + size, endY);

            div(startX + size, endX, startY, startY + size);
            div(startX + size, endX, startY + size, endY);
            sb.append(")");
        }
    }
    public static boolean isAllSame(int startX, int endX, int startY, int endY) {
        int color = arr[startX][startY];
        for (int i = startX; i < endX; i++) {
            for (int ii = startY; ii < endY; ii++) {
                if (color != arr[i][ii]) {
                    return false;
                }
            }
        }
        return true;
    }
}