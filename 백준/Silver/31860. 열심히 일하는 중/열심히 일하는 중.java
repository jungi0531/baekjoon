import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();

        try {
            // 입력 받기
            String[] N = br.readLine().split(" ");
            for (int i = 0; i < Integer.parseInt(N[0]); i++) {
                pq.add(Integer.parseInt(br.readLine()));
            }
            // 중요도가 가장 높은 일을 pq를 활용해서 빼서 -M 을 하고 난 후 다시 넣기.
            // 이후 만족감을 출력하는데, 만족감 = (전날 만족감 / 한 일의 중요도)
            int count = 0;
            int satis = 0;
            while (pq.peek() > Integer.parseInt(N[2])) {
                int temp = pq.poll();
                // 출력 값 list에 저장
                satis = satis / 2 + temp;
                list.add(satis);
                // 중요도 -M 한 후 다시 pq에 넣기
                temp -= Integer.parseInt(N[1]);
                pq.add(temp);
                count++;
            }
            // 출력
            bw.write(count + "\n");
            for (int i : list) {
                bw.write(i + "\n");
            }
            // 아래 반복문으로 출력하니 시간 초과가 발생 remove 메소드를 사용하는 과정에서 O(n)만큼 시간 복잡도
            // ArrayList로 구현했기에 맨 앞 요소를 제거하면 다른 모든 요소를 한 칸씩 땡겨야하기 때문.
            // 즉 반복문에서 O(n^2)만큼의 시간 복잡도가 발생했었음.
            // LinkedList를 사용하거나 for each문으로 시간 복잡도 줄이기
            // 따라서 위 for each문을 사용해 그냥 출력하도록 변경
//            for (int i = 0; i < count; i++) {
//                bw.write(list.remove(0) + "\n");
//            }
            bw.flush();
            bw.close();
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}