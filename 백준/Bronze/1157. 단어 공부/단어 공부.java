import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] count = new int[26];
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                count[input.charAt(i) - 'A']++;
            } else {
                count[input.charAt(i) - 'a']++;
            }
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
                maxIndex = i;
            }
        }
        Arrays.sort(count);
        if (count[count.length - 1] == count[count.length - 2]) {
            System.out.println("?");
        } else {
            System.out.println((char)(maxIndex + 'A'));
        }
    }
}