import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		
		for (int i = 0; i < input.length(); i++) {
			System.out.print(input.charAt(i));
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		scanner.close();
	}
}