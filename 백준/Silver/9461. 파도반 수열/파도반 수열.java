import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] array = new long[101];
        array[1] = 1;
        array[2] = 1;
        array[3] = 1;
        array[4] = 2;
        array[5] = 2;
        for (int i = 6; i <= 100; i++) {
            array[i] = array[i - 1] + array[i - 5];
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            // n = (n-1 + n-5)?
            // 1 1 1 2 2 3 4 5 7 9 12
            bw.write(String.valueOf(array[N] + "\n"));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}