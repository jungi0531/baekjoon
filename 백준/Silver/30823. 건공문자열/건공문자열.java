import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        //
        StringBuilder sb = new StringBuilder(input.substring(K - 1));
        StringBuilder temp = new StringBuilder(input.substring(0, K - 1));
        if ((N + K) % 2 == 0)
            sb.append(temp.reverse());
        else
            sb.append(temp);
        // 출력
        System.out.println(sb);
    }
}