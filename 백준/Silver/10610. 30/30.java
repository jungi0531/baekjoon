import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
        // 문자 배열로 만들어 정렬
        char[] arr = N.toCharArray();
        Arrays.sort(arr);
        // 0이 없다면 -1 출력 후 종료
        if (arr[0] != '0') {
            System.out.println(-1);
            return;
        }
        // 자리 수 합 구하기
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] - '0';
        }
        // 자리 수 합이 3이 아니면 -1 출력 후 종료
        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        // 3의 배수인 경우 해당 숫자 출력 <- 가장 큰 값은 내림차순 정렬 값
        StringBuilder sb = new StringBuilder(new String(arr));
        sb.reverse();
        System.out.println(sb);
    }
}