import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //
        int count = 1;
        int tempE = 1;
        int tempS = 1;
        int tempM = 1;
        while (!(E == tempE && S == tempS && M == tempM)) {
            tempE++;
            if (tempE > 15) tempE = 1;
            tempS++;
            if (tempS > 28) tempS = 1;
            tempM++;
            if (tempM > 19) tempM = 1;
            count++;
        }
        //
        System.out.println(count);
    }
}