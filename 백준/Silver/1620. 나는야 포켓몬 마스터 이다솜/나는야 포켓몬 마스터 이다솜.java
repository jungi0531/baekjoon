import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, String> hash = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();

        // 입력 받기
        // 포켓몬 개수 N과 맞춰야 하는 문제 수 M
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);

        // N개의 포켓몬 번호와 함께 저장 -> 해쉬 맵 활용
        // 시간 복잡도 때문에 2개의 해쉬 맵을 활용해 저장
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            hash.put(i + 1, input);
            hash2.put(input, i + 1);
        }

        // M개의 입력을 받고 숫자 입력시 이름 출력, 이름 입력시 숫자 출력
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            try {
                int temp = Integer.parseInt(input);
                bw.write(hash.get(temp) + "\n");
            } catch (NumberFormatException e) {
                bw.write(hash2.get(input) + "\n");
            }
        }
        // 버퍼 닫기
        bw.flush();
        bw.close();
        br.close();
    }
}