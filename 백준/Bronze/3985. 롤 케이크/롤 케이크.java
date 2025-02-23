import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] argv) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> hash = new HashMap<>();

        try {
            int L = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[L];
            int max_value = -1;
            int max_num = -1;
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                // 가장 긴 값을 가질 것이라 예상(다른 손님 고려 X)되는 손님 인덱스 구해놓기
                if (max_value < Integer.parseInt(input[1]) - Integer.parseInt(input[0])) {
                    max_num = i + 1;
                    max_value = Integer.parseInt(input[1]) - Integer.parseInt(input[0]);
                }
                // array 배열에 손님의 두 입력 값 사이 인덱스가 비어있으면 손님 인덱스 값 넣기
                for (int ii = Integer.parseInt(input[0]) - 1; ii < Integer.parseInt(input[1]); ii++) {
                    if (array[ii] == 0) {
                        array[ii] = i + 1;
                    }
                }
            }
            for (int i = 0; i < L; i++) {
                if (array[i] != 0) {
                    if (hash.containsKey(array[i]))
                        hash.put(array[i], hash.get(array[i]) + 1);
                    else
                        hash.put(array[i], 1);
                }
            }
            int temp_value = 0;
            int temp_num = 0;
            for (Integer i : hash.keySet()) {
                if (hash.get(i) > temp_value) {
                    temp_num = i;
                    temp_value = hash.get(i);
                }
            }
            // 출력하기
            bw.write(String.valueOf(max_num));
            bw.write("\n");
            bw.write(String.valueOf(temp_num));
            bw.flush();
            bw.close();
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}