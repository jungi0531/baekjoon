import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[5];

        try {
            for (int i = 0; i < 5; i++) {
                input[i] = br.readLine();
            }
            for (int i = 0; i < 15; i++) {
                for (int ii = 0; ii < 5; ii++) {
                    if (input[ii].length() > i) {
                        System.out.print(input[ii].charAt(i));
                    }
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}