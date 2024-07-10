import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double result = 0;
        int max = 0;
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            if (array[i] > max)
                max = array[i];
        }

        for (int i = 0; i < n; i++) {
            result += (double)array[i] / max * 100;
        }
        System.out.println(result / n);
        scanner.close();
    }
}