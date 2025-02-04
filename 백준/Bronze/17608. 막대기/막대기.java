import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int count = 0;
        int[] array;
        int N = Integer.parseInt(br.readLine());

        array = new int[N];
        for (int i = 0; i < N; i++)
        {
            array[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++)
        {
            if (array[array.length - i - 1] > max)
            {
                max = array[array.length - i - 1];
                count++;
            }
        }
        System.out.println(count);
    }
}