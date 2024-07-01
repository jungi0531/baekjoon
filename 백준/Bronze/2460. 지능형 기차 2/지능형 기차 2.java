import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = 0;
        int max = 0;

        for (int i = 0; i < 10; i++) {
            num -= scanner.nextInt();
            num += scanner.nextInt();
            if (num > max) {
                max = num;
            }
        }
        System.out.println(max);
        scanner.close();
    }
}