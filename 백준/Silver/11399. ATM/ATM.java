import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            // 입력 받기
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            String[] input = br.readLine().split(" ");
            // 입력 받은 출력하는 시간 정렬
            // 이렇게 정렬하려고 했으나 이러면 문자열 기준 정렬이기 때문에
            // 100이 12보다 앞에 오게 됨.
            // Arrays.sort(input);

            // 따로 정수형 배열에 문자열 값을 정수로 바꾸어 넣어서 정렬
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(array);
            int result = 0;
            int stack = 0;
            for (int i = 0; i < N; i++) {
                stack += array[i];
                result += stack;
            }
            // 정답 출력
            bw.write(String.valueOf(result) + "\n");
            bw.flush();
            bw.close();
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}