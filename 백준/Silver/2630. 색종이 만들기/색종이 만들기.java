import java.io.*;

public class Main {
    static int[][] arr; // 입력 배열
    static int white;   // 하얀색 색종이 개수
    static int blue;    // 파란색 색종이 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int ii = 0; ii < N; ii++) {
                arr[i][ii] = Integer.parseInt(input[ii]);
            }
        }
        // 만약 해당 bound 안의 숫자가 다 같지 않을 경우
        // 재귀로 또 나누기
        // 만약 해당 bound 안의 숫자가 다 같은 경우 -> 해당 색 count++
        white = 0;
        blue = 0;
        recur(0, N, 0, N);
        bw.write(String.valueOf(white) + "\n" + String.valueOf(blue) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void recur(int xFrom, int xTo, int yFrom, int yTo) {
        boolean allSame = true;
        int temp = arr[xFrom][yFrom];
        for (int i = xFrom; i < xTo; i++) {
            for (int ii = yFrom; ii < yTo; ii++) {
                if (temp != arr[i][ii]) {
                    allSame = false;
                    recur(xFrom, (xFrom + xTo) / 2, yFrom, (yFrom + yTo) / 2);
                    recur((xFrom + xTo) / 2, xTo, yFrom, (yFrom + yTo) / 2);
                    recur(xFrom, (xFrom + xTo) / 2, (yFrom + yTo) / 2, yTo);
                    recur((xFrom + xTo) / 2, xTo, (yFrom + yTo) / 2, yTo);
                    break;
                }
            }
            if (!allSame)
                break;
        }
        if (allSame) {
            if (temp == 0)
                white++;
            else
                blue++;
        }
    }
}