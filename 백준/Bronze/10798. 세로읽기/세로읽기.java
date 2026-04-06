import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] input = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String temp = br.readLine();
            for (int ii = 0; ii < temp.length(); ii++) {
                input[i][ii] = temp.charAt(ii);
            }
        }
        //
        for (int i = 0; i < 15; i++) {
            for (int ii = 0; ii < 5; ii++) {
                char cur = input[ii][i];
                if (Character.isLetterOrDigit(cur))
                    sb.append(cur);
            }
        }
        System.out.println(sb);
    }
}