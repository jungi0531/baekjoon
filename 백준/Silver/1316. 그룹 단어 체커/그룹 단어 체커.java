import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] exist = new int[26];
        int count = N;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < exist.length; j++) {
                exist[j] = 0;
            }
            String input = scanner.next();
            for (int j = 0; j < input.length() - 1; j++) {
                if (input.charAt(j) == input.charAt(j + 1)) {
                    continue;
                }
                else {
                    exist[input.charAt(j) - 'a']++;
                }
            }
            if (exist[input.charAt(input.length() - 1) - 'a'] != 0) {
                count--;
            }
            else {
                for (int j = 0; j < exist.length; j++) {
                    if (exist[j] > 1) {
                        count--;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }
}