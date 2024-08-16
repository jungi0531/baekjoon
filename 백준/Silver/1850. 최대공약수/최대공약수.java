import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long A = scanner.nextLong();
        long B = scanner.nextLong();

        long lcdValue = lcd(A, B);

        // StringBuilder를 사용하여 반복된 문자열을 한 번에 생성
        StringBuilder result = new StringBuilder();
        for (long i = 0; i < lcdValue; i++) {
            result.append("1");
        }
        System.out.println(result.toString());

        scanner.close();
    }

    public static long lcd (long A, long B) {
        if (B == 0) {
            return A;
        }
        return lcd(B, A % B);
    }
}
