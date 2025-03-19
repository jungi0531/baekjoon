import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, String> hash = new HashMap<>();

        // N과 M 입력 받기
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);

        // N개의 사이트와 비밀번호 해쉬에 넣기
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            hash.put(input[0], input[1]);
        }
        // 입력되는 사이트 주소(key)에 해당하는 비밀번호(value) 출력
        for (int i = 0; i < M; i++) {
            bw.write(hash.get(br.readLine()) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}