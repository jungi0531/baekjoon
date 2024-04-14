import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		String answer = "";
		
		int n = scanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			input = scanner.next();
			for (int j = 0; j < input.length(); j++) {
				if (answer.equals("")) answer = input;
				else {
					if (input.charAt(j) != answer.charAt(j)) {
						answer = answer.substring(0, j) + "?" + answer.substring(j + 1);
					}
				}
			}
		}
		scanner.close();
		System.out.println(answer);
	}
}