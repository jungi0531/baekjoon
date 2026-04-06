import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] count = new int[26];
            String input = br.readLine();
            for (int ii = 0; ii < input.length(); ii++) {
                if (input.charAt(ii) != ' ') {
                    count[input.charAt(ii) - 'a']++;
                }
            }
            // 가장 큰 값 인덱스 찾기 가장 큰 값이 여러개면 ? 출력
            int max = 0;
            int maxIndex = 0;
            for (int ii = 0; ii < count.length; ii++) {
                if (max < count[ii]) {
                    max = count[ii];
                    maxIndex = ii;
                }
            }
            Arrays.sort(count);
            if (count.length > 2 && count[count.length - 1] == count[count.length - 2]) {
                System.out.println("?");
            } else {
                System.out.println((char)(maxIndex + 'a'));
            }
        }
    }
}