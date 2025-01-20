import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = "NO";
        int T = Integer.parseInt(br.readLine());
        int[] fruit = {0, 0, 0, 0};

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("STRAWBERRY")) {
                fruit[0] += Integer.parseInt(input[1]);
            }
            else if (input[0].equals("BANANA")) {
                fruit[1] += Integer.parseInt(input[1]);
            }
            else if (input[0].equals("LIME")) {
                fruit[2] += Integer.parseInt(input[1]);
            }
            else if (input[0].equals("PLUM")) {
                fruit[3] += Integer.parseInt(input[1]);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (fruit[i] == 5) answer = "YES";
        }
        System.out.println(answer);
    }
}
