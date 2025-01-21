import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String input = br.readLine();

        Integer answer = 0;

        for (int i = 0; i < input.length(); i++){
            int temp = input.charAt(i) - 'a' + 1;
            answer += temp * (int)Math.pow(31, i);
        }

        System.out.println(answer);
    }
}
