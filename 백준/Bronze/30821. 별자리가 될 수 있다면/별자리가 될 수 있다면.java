import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long answer = 1L;
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 5; i++) {
            answer *= N - (i - 1);
        }
        for (int i = 1; i <= 5; i++) {
            answer /= i;
        }
        System.out.println(answer);
    }
}