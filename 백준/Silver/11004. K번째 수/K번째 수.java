import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int A = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(array);
            System.out.println(array[A - 1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}