import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100_001];

        bfs();

        System.out.println(arr[K]);
    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(N);
        while (!q.isEmpty()) {
            int remove = q.poll();

            if (remove == K) return;
            if (remove + 1 <= 100_000 && arr[remove + 1] == 0) {
                arr[remove + 1] = arr[remove] + 1;
                q.add(remove + 1);
            }
            if (remove * 2 <= 100_000 && arr[remove * 2] == 0) {
                arr[remove * 2] = arr[remove] + 1;
                q.add(remove * 2);
            }
            if (remove - 1 >= 0 && arr[remove - 1] == 0) {
                arr[remove - 1] = arr[remove] + 1;
                q.add(remove - 1);
            }
        }
    }
}