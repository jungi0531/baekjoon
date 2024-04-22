import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		int count = 0;
		
		while (true) {
			count = 0;
			input = scanner.nextLine();
			if (input.equals("#")) break;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == 'a') count++;
				else if (input.charAt(i) == 'e') count++;
				else if (input.charAt(i) == 'i') count++;
				else if (input.charAt(i) == 'o') count++;
				else if (input.charAt(i) == 'u') count++;
				else if (input.charAt(i) == 'A') count++;
				else if (input.charAt(i) == 'E') count++;
				else if (input.charAt(i) == 'I') count++;
				else if (input.charAt(i) == 'O') count++;
				else if (input.charAt(i) == 'U') count++;
			}
			System.out.println(count);
		}
		
		scanner.close();
	}
}