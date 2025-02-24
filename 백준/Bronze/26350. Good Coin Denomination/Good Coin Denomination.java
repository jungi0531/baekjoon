import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int cur = 0;
                boolean answer = true;
                bw.write("Denominations: ");
                for (int ii = 1; ii <= Integer.parseInt(input[0]); ii++) {
                    bw.write(input[ii] + " ");
                    // 현재 코인이 이전 코인 값의 두 배가 되지 않으면 Bad coin denominaions
                    if (cur * 2 > Integer.parseInt(input[ii])) {
                        answer = false;
                    }
                    cur = Integer.parseInt(input[ii]);
                }
                if (answer)
                    bw.write("\nGood coin denominations!\n\n");
                else
                    bw.write("\nBad coin denominations!\n\n");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}