import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		scanner.nextInt();
		String input = scanner.next();
		
		String result = input.substring(input.length() - 5, input.length());
		
		System.out.println(result);
		
		scanner.close();
	}
}