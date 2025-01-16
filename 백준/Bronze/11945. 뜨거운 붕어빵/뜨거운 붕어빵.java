import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] num = br.readLine().split(" ");
            for (int i = 0; i < Integer.parseInt(num[0]); i++) {
                String input = br.readLine();
                StringBuilder sb = new StringBuilder(input);
                System.out.println(sb.reverse());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}