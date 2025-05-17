import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        arr = new int[100001];

        // bfs로 탐색 -> 최단 경로를 찾는 것이기에 답을 찾아도 최단인지 알 수 없는 dfs보다 적합
        arr[N] = 1;
        bfs(N);

        bw.write(String.valueOf(arr[K] - 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs(int curIndex) {
        Queue<Integer> q = new LinkedList<>();

        q.add(curIndex);
        while (!q.isEmpty()) {
            int temp = q.remove();
            // 답이면 리턴
            if (temp == K)
                return;
            // 범위 확인하고 방문하지 않은 곳이라면 arr 해당 인덱스에 현재 값 + 1을 저장하고 해당 인덱스를 큐에 추가
            if (temp - 1 >= 0 && arr[temp - 1] == 0) {
                arr[temp - 1] = arr[temp] + 1;
                q.add(temp - 1);
            }
            if (temp + 1 <= 100000 && arr[temp + 1] == 0) {
                arr[temp + 1] = arr[temp] + 1;
                q.add(temp + 1);
            }
            if (temp * 2 <= 100000 && arr[temp * 2] == 0) {
                arr[temp * 2] = arr[temp] + 1;
                q.add(temp * 2);
            }
        }
    }
}