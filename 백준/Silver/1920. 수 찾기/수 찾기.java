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
            System.out.println(binarySearch(array, input, 0, array.length - 1));
        }

        scanner.close();
    }
    public static int binarySearch(int[] array, int input, int left, int right) {
        int mid = (left + right) / 2;
        if (left > right) {
            return 0;
        }
        else if (array[mid] == input) {
            return 1;
        }
        else if (array[mid] < input) {
            return binarySearch(array, input, mid + 1, right);
        }
        else if (array[mid] > input) {
            return binarySearch(array, input, left, mid - 1);
        }
        return 0;
    }
}