import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> hash = new HashMap<>();
        String[] num = br.readLine().split(" ");

        for (int i = 0; i < Integer.parseInt(num[0]); i++) {
            String[] input = br.readLine().split(" ");
            String temp = "";
            for (int ii = 0; ii < 3; ii++) {
                temp += input[2 + ii];
            }
            if (hash.containsKey(temp))
                hash.put(temp, "");
            else
                hash.put(temp, input[1]);
        }

        for (int i = 0; i < Integer.parseInt(num[1]); i++) {
            String[] input = br.readLine().split(" ");
            String temp = "";
            for (int ii = 0; ii < input.length; ii++) {
                temp += input[ii];
            }
            if (!hash.containsKey(temp))
                System.out.println("!");
            else if (hash.get(temp).equals(""))
                System.out.println("?");
            else
                System.out.println(hash.get(temp));
        }
    }
}
