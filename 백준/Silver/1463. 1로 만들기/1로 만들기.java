import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n + 1];

        array[1] = 0;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + 1;
            if (i % 2 == 0) {
                array[i] = Math.min(array[i], array[i / 2] + 1);
            }
            if (i % 3 == 0) {
                array[i] = Math.min(array[i], array[i / 3] + 1);
            }
        }
        System.out.println(array[n]);

        scanner.close();
    }
}