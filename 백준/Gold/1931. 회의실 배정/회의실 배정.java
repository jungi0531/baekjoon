import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }
        // 끝나는 시간 순 정렬, 끝나는 시간이 같다면 시작 시간이 빠른 순 정렬
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])  return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prevEndTime = -1;
        for (int i = 0; i < N; i++) {
            if (prevEndTime <= meeting[i][0]) {
                prevEndTime = meeting[i][1];
                count++;
            }
        }
        // 출력
        System.out.println(count);
    }
}