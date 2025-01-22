import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hash = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            hash.add(input[i]);
        }

        String[] temp = br.readLine().split(" ");

        for (int i = 0; i < N - 1; i++) {
            hash.remove(temp[i]);
        }

        System.out.println(hash.toArray()[0]);
    }
}
