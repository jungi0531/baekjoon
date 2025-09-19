import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //
        int N = Integer.parseInt(br.readLine());
        int[] vote = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            vote[Integer.parseInt(st.nextToken())]++;
        }
        //
        boolean onlyOne = true;
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 1; i <= N; i++) {
            if (maxValue < vote[i]) {
                maxValue = vote[i];
                maxIndex = i;
                onlyOne = true;
            }
            else if (maxValue == vote[i]) {
                onlyOne = false;
            }
        }
        if (onlyOne)
            System.out.println(maxIndex);
        else
            System.out.println("skipped");
    }
}