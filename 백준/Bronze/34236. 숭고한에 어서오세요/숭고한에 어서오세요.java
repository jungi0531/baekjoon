import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]) - a;

        System.out.println(a + (d * N));
    }
}