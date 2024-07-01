import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        boolean arranged = true;
        int a = 0, b = 0;
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[n];
        int[] tempArray = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    k--;
                    if (k == 0) {
                        a = array[i];
                        b = array[i + 1];
                        break;
                    }
                }
            }
            if (k == 0)
                break;
        }

        if (k != 0)
            System.out.println(-1);
        else
            System.out.println(a + " " + b);

        scanner.close();
    }
}