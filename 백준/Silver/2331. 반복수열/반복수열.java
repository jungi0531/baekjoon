import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        list.add(A);
        while (true) {
            int temp = list.get(list.size() - 1);
            double add = 0;
            while (temp > 0) {
                add += Math.pow(temp % 10, P);
                temp /= 10;
            }
            if (list.contains((int)add)) {
                answer = list.indexOf((int)add);
                break;
            }
            list.add((int)add);
        }
        System.out.println(answer);
    }
}