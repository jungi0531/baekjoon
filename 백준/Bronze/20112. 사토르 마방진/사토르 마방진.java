import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        //
        boolean isDecal = true;
        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < N; ii++) {
                if (input[i].charAt(ii) != input[ii].charAt(i)) {
                    isDecal = false;
                    break;
                }
            }
            if (!isDecal)
                break;
        }
        if (isDecal)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}