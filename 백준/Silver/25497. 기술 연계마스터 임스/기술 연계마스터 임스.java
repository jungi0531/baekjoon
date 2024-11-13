import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lCount = 0, sCount = 0, result = 0;
        int N = scanner.nextInt();
        String input = scanner.next();

        for (int i = 0; i < N; i++) {
            if (Character.isDigit(input.charAt(i))) {
                result++;
            }
            else if (input.charAt(i) == 'L') lCount++;
            else if (input.charAt(i) == 'S') sCount++;
            else if (input.charAt(i) == 'R') {
                if (lCount > 0) {
                    result++;
                    lCount--;
                }
                else {
                    break;
                }
            }
            else if (input.charAt(i) == 'K') {
                if (sCount > 0) {
                    result++;
                    sCount--;
                }
                else {
                    break;
                }
            }
        }
        System.out.println(result);

        scanner.close();
    }
}