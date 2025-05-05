import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] fruit = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            fruit[i] = Integer.parseInt(input[i]);
        }
        // 슬라이딩 윈도우 사용
        HashMap<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < N; right++) {
            int curFruit = fruit[right];
            // 현재 과일 바구니에 추가
            if (basket.containsKey(curFruit))
                basket.put(curFruit, basket.get(curFruit) + 1);
            else
                basket.put(curFruit, 1);
            // 추가했는데 과일 개수가 2개가 넘으면 left를 땡겨오기
            while (basket.size() > 2) {
                int removeFruit = fruit[left];
                basket.put(removeFruit, basket.get(removeFruit) - 1);
                if (basket.get(removeFruit) == 0)
                    basket.remove(removeFruit);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        // 정답 length 출력
        bw.write(String.valueOf(maxLength) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}