import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 한 팀에 N 2명 M 1명 K명 인턴십
        int count = 0;
        while (N >= 2 && M >= 1 && N + M - 3 >= K) {
            N -= 2;
            M -= 1;
            count++;
        }
        // 출력
        System.out.println(count);
    }
}