import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];
        int[][] curScore = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        // N이 1 또는 2인 예외 처리
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
        // N이 1 또는 2인 경우는 예외 처리 했기에, 첫 계단과 두 번째 계단 값에 초기값을 주고 DP 적용
        curScore[1][0] = array[1];
        curScore[2][0] = array[2];
        curScore[2][1] = array[1] + array[2];
        // DP
        for (int i = 3; i <= N; i++) {
            for (int ii = 0; ii < 2; ii++) {
                if (ii == 0)
                    // ii가 0인 경우는 이전에 두 칸을 오른 것이므로 두 칸 전 값 중 큰 값과 현재 계단 값 더하기
                    curScore[i][ii] = Math.max(curScore[i - 2][0], curScore[i - 2][1]) + array[i];
                else
                    // ii가 1인 경우는 이전에 한 칸을 오른 것이므로 한 칸은 연속으로 두 번 오를 수 없기에 이전 0 인덱스 값과 현재 계단 값 더하기
                    curScore[i][ii] = curScore[i - 1][0] + array[i];
            }
        }
        // 출력
        bw.write(String.valueOf(Math.max(curScore[N][0], curScore[N][1]) + "\n"));
        bw.flush();
        bw.close();
        br.close();
    }
}