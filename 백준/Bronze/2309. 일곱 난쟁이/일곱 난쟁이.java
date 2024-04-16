import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = 0, b = 0;
		int check = 0;
		int[] input = new int[9];
		int sum = 0;
		
		for (int i = 0; i < input.length; i++) {
			input[i] = scanner.nextInt();
			sum += input[i];
		}
		Arrays.sort(input);
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if ((sum - input[i] - input[j]) == 100) {
					a = i;
					b = j;
					check++;
					break;
				}
			}
			if (check == 1) break;
		}
		
		for (int i = 0; i < input.length; i++) {
			if (i != a && i != b)
				System.out.println(input[i]);
		}
	}
}