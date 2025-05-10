import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        int B = Integer.parseInt(num[2]);
        int[][] ground = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int ii = 0; ii < M; ii++) {
                ground[i][ii] = Integer.parseInt(input[ii]);
            }
        }
        // 모든 땅 높이를 같게 하는 시간과 같은 땅의 높이를 출력
        // 최소 땅 높이부터 최대 땅 높이까지 경우의 수 계산 후 가능한 가장 땅의 높이가 높은 경우가 답
        int minTime = Integer.MAX_VALUE;
        int height = 0;
        for (int i = 256; i >= 0; i--) {
            int curTime = 0;
            int blockCount = B;
            boolean blockLack = false;
            for (int ii = 0; ii < N; ii++) {
                for (int iii = 0; iii < M; iii++) {
                    if (ground[ii][iii] > i) {
                        curTime += 2 * (ground[ii][iii] - i);
                        blockCount += (ground[ii][iii] - i);
                    }
                    else if (ground[ii][iii] < i) {
                        curTime += i - ground[ii][iii];
                        blockCount -= i - ground[ii][iii];
                    }
                }
            }
            // 가장 적은 시간이 걸린 경우 저장
            if (blockCount >= 0 && curTime < minTime) {
                minTime = curTime;
                height = i;
            }
            // System.out.println("i 값: " + i + " curTime: " + curTime + " height: " + height);
        }
        // 정답 출력
        bw.write(String.valueOf(minTime) + " " + String.valueOf(height) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}