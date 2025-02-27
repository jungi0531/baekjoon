import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            // 입력 받기
            String A = br.readLine();
            String B = br.readLine();
            String C = br.readLine();
            // 출력하기
            bw.write(String.valueOf(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C)) + "\n");
            bw.write(String.valueOf(Integer.parseInt(A + B) - Integer.parseInt(C)) + " \n");
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}