import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		
		while (true) {
			input = scanner.nextLine();
			if (input.equals("EOI")) break;
			input = input.toUpperCase();
			if (input.contains("NEMO")) 
				System.out.println("Found");
			else
				System.out.println("Missing");
		}
		scanner.close();
	}
}