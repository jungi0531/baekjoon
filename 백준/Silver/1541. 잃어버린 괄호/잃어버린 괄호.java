import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = 0;
        // 괄호 쳐서 식 값 최소 -> - 나오면 다시 - 나올 때까지 괄호(마이너스 값을 최대로 묶기)
        // 먼저 -로 스플릿 하고 각 스플릿 덩어리 값 구한 뒤 첫 값에서 빼기
        String input = br.readLine();
        // -로 덩어리 나누기
        String[] splitMinus = input.split("-");
        // -로 나눈 각 덩어리 안의 숫자 합을 저장할 정수 배열
        int[] arr = new int[splitMinus.length];
        for (int i = 0; i < splitMinus.length; i++) {
            // 각 덩어리들의 숫자 합 arr에 저장
            String[] splitPlus = splitMinus[i].split("\\+");
            for (int ii = 0; ii < splitPlus.length; ii++) {
                arr[i] += Integer.parseInt(splitPlus[ii]);
            }
        }
        // 첫 값에서 -로 나눈 덩어리들 숫자 합 빼기
        result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result -= arr[i];
        }
        // 출력
        bw.write(String.valueOf(result) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}