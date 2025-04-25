import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받기
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        long[] tree = new long[N];
        String[] input = br.readLine().split(" ");
        long max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(input[i]);
            // 최대 값 구해놓기
            if (tree[i] > max)
                max = tree[i];
        }
        // 최대 값을 기준으로 이진 탐색?
        long start = 0;
        long mid = 0;
        while (start <= max) {
            mid = (start + max) / 2;
            // mid 높이에서 나무 잘라보고 M보다 부족하면 높이 내리고 너무 넘치면 좀 올리고
            long cur = cutting(tree, mid);
            // System.out.println("cur: " + cur + " M: " + M + " mid: " + mid);
            if (cur < M)
                max = mid - 1;
            else
                start = mid + 1;
        }
        // 정답 출력
        bw.write(String.valueOf(max) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static long cutting(long[] tree, long mid) {
        // mid 높이에서 모든 나무 날라낸 윗 쪽 값 반환
        // mid 보다 짧은 나무에 대해선 0
        long sum = 0;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] > mid)
                sum += tree[i] - mid;
        }
        return sum;
    }
}