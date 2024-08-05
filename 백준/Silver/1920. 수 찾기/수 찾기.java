import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int input = scanner.nextInt();
            if (Arrays.binarySearch(array, input) >= 0) {
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }

        scanner.close();
    }
}