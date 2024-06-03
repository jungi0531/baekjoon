import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		scanner.nextInt();
		String input = scanner.next();
		
		int sCount = 0;
		int tCount = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 's') sCount++;
			if (input.charAt(i) == 't') tCount++;
		}
		
		while (true) {
			if (sCount == tCount) break;
			if (input.charAt(0) == 's') {
				sCount--;
				input = input.substring(1, input.length());
			}
			else if (input.charAt(0) == 't') {
				tCount--;
				input = input.substring(1, input.length());
			}
		}
		System.out.println(input);
		
		scanner.close();
	}
}