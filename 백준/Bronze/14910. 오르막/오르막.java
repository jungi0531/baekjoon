import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input;
		int prevInput = Integer.MIN_VALUE;
		boolean result = true;
		
		while (scanner.hasNextInt()) {
			input = scanner.nextInt();
			if (prevInput > input) {
				result = false;
				break;
			}
			prevInput = input;
		}
		if (result)
			System.out.println("Good");
		else 
			System.out.println("Bad");
		
		scanner.close();
	}
}