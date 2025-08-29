import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[5];

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == 'u') {
                count[0]++;
            }
            else if (input.charAt(i) == 'o') {
                count[1]++;
            }
            else if (input.charAt(i) == 's') {
                count[2]++;
            }
            else if (input.charAt(i) == 'p') {
                count[3]++;
            }
            else if (input.charAt(i) == 'c') {
                count[4]++;
            }
        }
        int min = 1000;
        for (int i = 0; i < 5; i++) {
            min = Math.min(count[i], min);
        }
        System.out.println(min);
    }
}