import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);
        // 거리를 이분 탐색.
        // 만약 현재 거리로 모든 공유기 설치 불가 -> 거리 감소
        // 만약 현재 거리로 모든 공유가 설치 가능 -> 거리 증가
        int min = 1;
        int max = house[house.length - 1] - house[0];
        int result = 0;
        while (min <= max) {
            int d = (max + min) / 2;
            int count = 1;
            // 머시기 수행
            for (int i = 0; i < N - 1; i++) {
                for (int ii = i + 1; ii < N; ii++) {
                    if (house[ii] - house[i] >= d) {
                        count++;
                        i = ii - 1;
                        break;
                    }
                }
            }
            if (count >= C) {
                min = d + 1;
                if (result < d) {
                    result = d;
                }
            }
            else {
                max = d - 1;
            }
        }
        // 출력
        System.out.println(result);
    }
}