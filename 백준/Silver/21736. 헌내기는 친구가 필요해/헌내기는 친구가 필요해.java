import java.io.*;

public class Main {
    static int count;   // 만난 사람 수
    static String[] campus;
    static boolean[][] visited; // 갔던 곳 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        campus = new String[N];
        for (int i = 0; i < N; i++) {
            campus[i] = br.readLine();
        }
        count = 0;
        visited = new boolean[N][M];    // 갔던 곳 체크
        // 도연 I에서부터 시작해서 재귀적으로 상하좌우 탐색
        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < M; ii++) {
                if (campus[i].charAt(ii) == 'I') {
                    recur(i, ii);
                }
            }
        }
        // 정답 출력(아무도 못 만나면 TT 출력)
        if (count == 0)
            bw.write("TT\n");
        else
            bw.write(String.valueOf(count) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void recur(int i, int ii) {
        if (visited[i][ii] || campus[i].charAt(ii) == 'X')
            return;
        visited[i][ii] = true;
        if (campus[i].charAt(ii) == 'P')
            count++;
        int[] x = {1, 0, -1, 0};
        int[] y = {0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            if (i + x[k] >= 0 && i + x[k] < campus.length) {
                if (ii + y[k] >= 0 && ii + y[k] < campus[0].length()) {
                    recur(i + x[k], ii + y[k]);
                }
            }
        }
    }
}