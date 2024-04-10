import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		String[] splited;
		int n = scanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			input = scanner.next();
			splited = input.split(",");
			System.out.println(Integer.parseInt(splited[0]) + Integer.parseInt(splited[1]));
		}
	}
}