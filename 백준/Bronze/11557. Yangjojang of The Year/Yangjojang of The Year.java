import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                int max = Integer.MIN_VALUE;
                String result = "";
                for (int ii = 0; ii < N; ii++) {
                    String[] input = br.readLine().split(" ");
                    if (max < Integer.parseInt(input[1])) {
                        max = Integer.parseInt(input[1]);
                        result = input[0];
                    }
                }
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}