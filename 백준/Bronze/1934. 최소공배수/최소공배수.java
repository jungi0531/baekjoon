import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int result = A * B;
            int temp = A;
            while (B % A != 0) {
                temp = B % A;
                B = A;
                A = temp;
            }
            System.out.println(result / temp);
        }
        scanner.close();
    }
}