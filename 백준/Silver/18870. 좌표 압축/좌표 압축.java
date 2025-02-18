import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            // 입력 받기
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(input[i]);
            }
            // 좌표 압축하기.. how? -> 배열의 각 숫자에다가 rank 부여하기
            int[] copyArray = array.clone();
            HashMap<Integer, Integer> hash = new HashMap<>();
            int value = 0;
            Arrays.sort(copyArray);
            // 정렬된 배열을 반복문을 돌면서 중복 없이 value 값 부여하기
            for (int i = 0; i < N; i++) {
                if (!hash.containsKey(copyArray[i])) {
                    hash.put(copyArray[i], value);
                    value++;
                }
            }
            // 정답 출력
            // 해쉬에 저장된 value 값을 통해서 해당 인덱스의 있는 좌표를 압축된 좌표로 출력하기
            for (int i = 0; i < N; i++) {
                bw.write(hash.get(array[i]) + " ");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}