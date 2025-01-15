import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            //System.out.println(input[0] + " " + input[1]);
            for (int ii = 0; ii < input[1].length(); ii++) {
                for (int iii = 0; iii < Integer.parseInt(input[0]); iii++) {
                    System.out.print(input[1].charAt(ii));
                }
            }
            System.out.println();
        }
    }
}
