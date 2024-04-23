import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] input = new int[10];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				input[j] = scanner.nextInt();
			}
			Arrays.sort(input);
			System.out.println(input[7]);
		}
		scanner.close();
	}
}