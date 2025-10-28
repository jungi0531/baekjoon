import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        // M이 0인 경우 고장난 숫자가 없음 <- 채널 수 길이 그냥 출력하면 101 같은 건 1인데 3 출력 됨
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int index = Integer.parseInt(st.nextToken());
                broken[index] = true;
            }
        }
        // 기본 세팅 100 채널
        int answer = Math.abs(N - 100);

        for (int i = 0; i <= 1_000_000; i++) {
            int count = 0;
            boolean possible = true;
            String num = Integer.toString(i);
            for (char c : num.toCharArray()) {
                // 바로 해당 채널을 틀 수 없는 채널은 고려 X
                // 어차피 각 모든 수를 고려하기 때문에
                if (broken[c - '0']) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                count = num.length() + Math.abs(N - i);
                answer = Math.min(answer, count);
            }
        }
        //
        System.out.println(answer);
    }
}