import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            // 입력 받기
            String[] input = new String[3];
            for (int i = 0; i < 3; i++) {
                input[i] = br.readLine();
            }
            // 우선 규칙은 생각하지 않고 정답 자리수에 해당하는 숫자 구하기
            int temp = 0;
            for (int i = 0; i < 3; i++) {
                try {
                    temp = Integer.parseInt(input[i]) + (3 - i);
                    break;
                } catch (NumberFormatException e) {}
            }
            // 정답 출력
            // 이때 규칙에 따라 해당하면 Fizz, Buzz, FizzBuzz로 바꾸어 출력
            if (temp % 3 == 0 && temp % 5 == 0)
                bw.write("FizzBuzz");
            else if (temp % 3 == 0)
                bw.write("Fizz");
            else if (temp % 5 == 0)
                bw.write("Buzz");
            else
                bw.write(String.valueOf(temp));
            bw.flush();
            bw.close();
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}