import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer>[] sushi = new PriorityQueue[200001];
        int[] consumer;
        for (int i = 0; i < sushi.length; i++)
            sushi[i] = new PriorityQueue<>();
        try {
            // 손님 수 및 초밥 개수 입력 받기
            String[] temp = br.readLine().split(" ");
            // 손님 및 초밥 배열 초기화
            consumer = new int[Integer.parseInt(temp[0])];
            // 손님 먹은 초밥 입력 받기
            for (int i = 0; i < Integer.parseInt(temp[0]); i++) {
                String[] input = br.readLine().split(" ");
                for (int ii = 0; ii < Integer.parseInt(input[0]); ii++) {
                    // 스시 PQ배열에서 초밥 번호 인덱스에 손님 번호 add 하기
                    sushi[Integer.parseInt(input[ii + 1])].add(i);
                }
            }
            // 초밥 번호에 해당하는 가장 우선순위(손님 번호) 손님 한 명 제거하면서 해당 손님 먹은 초밥 개수 ++
            String[] sushiMenu = br.readLine().split(" ");
            for (int i = 0; i < Integer.parseInt(temp[1]); i++) {
                if (!sushi[Integer.parseInt(sushiMenu[i])].isEmpty()) {
                    consumer[sushi[Integer.parseInt(sushiMenu[i])].remove()]++;
                }
            }
            // 손님 먹은 개수 출력
            for (int i = 0; i < consumer.length; i++) {
                System.out.print(consumer[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}