import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                String A = "";
                String B = "";
                String input = br.readLine();

                if (input.length() % 2 == 0) {
                    int index = 0;
                    while (true) {
                        A += input.charAt(index++);
                        if (index >= input.length()) break;
                        B += input.charAt(index++);
                        if (index >= input.length()) break;
                    }
                }
                else {
                    int index = 0;
                    while (true) {
                        A += input.charAt(index++);
                        if (index >= input.length()) break;
                        B += input.charAt(index++);
                        if (index >= input.length()) break;
                    }
                    index = 0;
                    while (true) {
                        B += input.charAt(index++);
                        if (index >= input.length()) break;
                        A += input.charAt(index++);
                        if (index >= input.length()) break;
                    }
                }
                System.out.println(A);
                System.out.println(B);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}