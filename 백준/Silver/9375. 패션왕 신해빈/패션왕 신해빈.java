import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hash = new HashMap<>();

        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            // 의상 개수 입력
            int n = Integer.parseInt(br.readLine());
            for (int ii = 0; ii < n; ii++) {
                // 의상 이름 입력 받기 - [1]에 의상 종류가 있음
                String[] input = br.readLine().split(" ");
                // 해쉬에 해당 의상 종류 카운트해서 넣기
                if (hash.containsKey(input[1])) {
                    hash.put(input[1], hash.get(input[1]) + 1);
                }
                else {
                    hash.put(input[1], 1);
                }
            }
            int result = 1;
            // 각 의상 종류 중 하나를 뽑는 nC1에서 안 입는 경우 포함으로 n+1C1 곱하기
            for (String temp : hash.keySet()) {
                result *= hash.get(temp) + 1;
            }
            // 아무 것도 입지 않는 경우 하나 제외 후 출력
            bw.write(String.valueOf(result - 1) + "\n");
            // 다음 테스트 케이스에도 사용하기 위해 해쉬 클리어
            hash.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}