import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Comparator.reverseOrder()로 큰 값을 우선 순위로
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                // pq에서 가장 큰 값 출력 후 제거 / 비었으면 0 출력
                if (pq.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(String.valueOf(pq.poll()) + "\n");
            }
            else {
                // 해당 숫자 pq에 추가
                pq.add(input);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}