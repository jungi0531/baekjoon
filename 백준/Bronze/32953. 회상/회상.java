import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hash = new HashMap<>();
        String[] num = br.readLine().split(" ");
        int count = 0;

        for (int i = 0; i < Integer.parseInt(num[0]); i++) {
            int K = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            for (int ii = 0; ii < K; ii++) {
                if (hash.containsKey(input[ii]))
                    hash.put(input[ii], hash.get(input[ii]) + 1);
                else
                    hash.put(input[ii], 1);
            }
        }
        for (String s : hash.keySet()) {
            if (hash.get(s) >= Integer.parseInt(num[1]))
                count++;
        }
        System.out.println(count);
    }
}