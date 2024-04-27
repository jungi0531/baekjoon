import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] result = new int[8];
		String input = "";
		int n = scanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 8; j++) {
				result[j] = 0;
			}
			input = scanner.next();
			for (int j = 0; j < input.length() - 2; j++) {
				result[check(j, input)]++;
			}
			for (int j = 0; j < 8; j++) {
				System.out.print(result[j] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}
	public static int check(int j, String input) {
		if (input.charAt(j) == 'T') {
			if (input.charAt(j + 1) == 'T') {
				if (input.charAt(j + 2) == 'T') {
					return 0;
				}
				else {
					return 1;
				}
			}
			else {
				if (input.charAt(j + 2) == 'T') {
					return 2;
				}
				else {
					return 3;
				}
			}
		}
		else {
			if (input.charAt(j + 1) == 'T') {
				if (input.charAt(j + 2) == 'T') {
					return 4;
				}
				else {
					return 5;
				}
			}
			else {
				if (input.charAt(j + 2) == 'T') {
					return 6;
				}
				else {
					return 7;
				}
			}
		}
	}
}