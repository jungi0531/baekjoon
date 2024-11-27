import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>((s1, s2) -> {
            return s1.compareTo(s2);
        });

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] array = new int[M - N + 1];

        for (int i = N; i <= M; i++) {
            String temp = Integer.toString(i);
            String result = "";
            for (int ii = 0; ii < temp.length(); ii++) {
                if (temp.charAt(ii) == '0') result += "zero";
                else if (temp.charAt(ii) == '1') result += "one";
                else if (temp.charAt(ii) == '2') result += "two";
                else if (temp.charAt(ii) == '3') result += "three";
                else if (temp.charAt(ii) == '4') result += "four";
                else if (temp.charAt(ii) == '5') result += "five";
                else if (temp.charAt(ii) == '6') result += "six";
                else if (temp.charAt(ii) == '7') result += "seven";
                else if (temp.charAt(ii) == '8') result += "eight";
                else if (temp.charAt(ii) == '9') result += "nine";
            }
            map.put(result, i);
        }
        int i = 1;
        for (String temp : map.keySet()) {
            System.out.print(map.get(temp) + " ");
            if (i++ % 10 == 0) System.out.println();
        }
    }
}
