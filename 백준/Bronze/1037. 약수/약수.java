import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] input = new int[n];
		
		for (int i = 0; i < n; i++) {
			input[i] = scanner.nextInt();
		}
		scanner.close();
		
		Arrays.sort(input);
		
		System.out.println(input[0] * input[input.length - 1]);
	}
}