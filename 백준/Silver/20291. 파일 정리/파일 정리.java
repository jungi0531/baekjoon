import java.io.*;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> tree = new TreeMap<>();

        try {
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split("\\.");
                if (tree.containsKey(input[1])) {
                    tree.put(input[1], tree.get(input[1]) + 1);
                }
                else {
                    tree.put(input[1], 1);
                }
            }
            for (String temp : tree.keySet()) {
                System.out.println(temp + " " + tree.get(temp));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}