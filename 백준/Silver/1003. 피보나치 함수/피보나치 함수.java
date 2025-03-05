import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테이스 케이스 수 입력 받기
        int T = Integer.parseInt(br.readLine());
        int[] input = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(br.readLine());
            if (input[i] > max)
                max = input[i];
        }
        // max 값이 0인 경우에도 count[1] 인덱스가 존재해야 하므로 max + 2
        int[][] count = new int[max + 2][2];
        count[0][0] = 1;
        count[0][1] = 0;
        count[1][0] = 0;
        count[1][1] = 1;
        for (int i = 2; i <= max; i++) {
            count[i][0] = count[i - 1][0] + count[i - 2][0];
            count[i][1] = count[i - 1][1] + count[i - 2][1];
        }
        for (int i = 0; i < T; i++) {
            bw.write(String.valueOf(count[input[i]][0] + " " + String.valueOf(count[input[i]][1] + "\n")));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}