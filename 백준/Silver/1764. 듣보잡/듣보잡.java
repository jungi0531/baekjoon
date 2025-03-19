import java.io.*;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> hash = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        int count = 0;

        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        for (int i = 0; i < N; i++) {
            hash.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            // 듣도 못한 사람 hash에 해당 이름이 있으면 pq에 넣기
            if (hash.contains(temp)) {
                pq.add(temp);
                count++;
            }
        }
        // for each문으로 pq(문자열 정렬됨)를 돌면서 출력
        bw.write(String.valueOf(count) + "\n");
        //이렇게 사용하면 정렬이 안 된대
//        for (String temp : pq) {
//            bw.write(temp + "\n");
//        }
        while (!pq.isEmpty())
            bw.write(pq.poll() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}