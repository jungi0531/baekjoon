import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = 0;
		int n = scanner.nextInt();
		int[] count = new int[101];
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			input = scanner.nextInt();
			if (count[input] == 0) count[input]++;
			else result++;
		}
		scanner.close();
		System.out.println(result);
	}
}