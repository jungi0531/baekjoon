import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // n( <= 10)을 1, 2, 3의 조합을 가지고 만들 수 있는 경우의 수 출력
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            recur(list, n, 1);
            bw.write(String.valueOf(count) + "\n");
        }
        // 버퍼 닫기
        bw.flush();
        bw.close();
        br.close();
    }
    public static void recur(ArrayList<Integer> list, int n, int min) {
        // curList의 요소 합 구하기
        int sum = 0;
        for (Integer temp : list) {
            sum += temp;
        }
        if (sum > n) {
            // 요소들의 합이 n보다 크면 범위를 벗어나므로 return
            return ;
        }
        else if (sum == n) {
            // 요소들의 합이 n이면 답이므로 count++
            count++;
            return ;
        }
        // 1 ~ 3 숫자만 활용해서 DFS
        for (int i = 1; i <= 3; i++) {
            list.add(i);
            recur(list, n, i);
            list.remove(list.size() - 1);
        }
    }
}