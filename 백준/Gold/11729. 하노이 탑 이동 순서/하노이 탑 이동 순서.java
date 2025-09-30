import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        //
        sb.append((int)Math.pow(2, N) - 1).append("\n");
        hanoi(1, 2, 3, N);
        // 출력
        System.out.println(sb);
    }
    public static void hanoi(int start, int to, int end, int N) {
        if (N > 0) {
        hanoi(start, end, to, N - 1);
        sb.append(String.valueOf(start)).append(" ").append(String.valueOf(end)).append("\n");
        hanoi(to, start, end, N - 1);
        }
    }
}