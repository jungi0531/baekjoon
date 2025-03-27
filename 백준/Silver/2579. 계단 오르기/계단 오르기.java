import java.io.*;

public class Main {
    static int N;
    static int[] array;
    static int score;
    static int[][] curScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        N = Integer.parseInt(br.readLine());
        array = new int[N + 1];
        curScore = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        //
        if (N == 1) {
            bw.write(String.valueOf(array[1]) + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        else if (N == 2) {
            bw.write(String.valueOf(array[1] + array[2]) + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        curScore[1][0] = array[1];
        curScore[2][0] = array[2];
        curScore[2][1] = array[1] + array[2];
        for (int i = 3; i <= N; i++) {
            for (int ii = 0; ii < 2; ii++) {
                // 두 칸 전 sequence 2인거랑 한 칸 전 sequence 0, 1 중 큰 거
                // sequence 0에는 2칸 전 거만
                // sequence 1, 2에는 1칸 전 거만
                if (ii == 0)
                    curScore[i][ii] = Math.max(curScore[i - 2][0], curScore[i - 2][1]) + array[i];
                else
                    curScore[i][ii] = curScore[i - 1][0] + array[i];
            }
        }
        bw.write(String.valueOf(Math.max(curScore[N][0], curScore[N][1]) + "\n"));
        bw.flush();
        bw.close();
        br.close();
    }
}