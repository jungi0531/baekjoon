import java.io.*;

public class Main {
    public static void main(String[] argv) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            // 입력 받기
            String input = br.readLine();
            // 첫 문자와 다른 문자가 나올 때까지 인덱스(count) 증가 시키기
            int count = 0;
            while (count < input.length() && input.charAt(0) == input.charAt(count))
                count++;
            // count 값 출력
            bw.write(String.valueOf(count));
            bw.flush();
            bw.close();
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}