import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int L = scanner.nextInt();
		int P = scanner.nextInt();
		
		for (int i = 0; i < 5; i++) {
			int input = scanner.nextInt();
			System.out.print(input - (L * P) + " ");
		}
		
		scanner.close();
	}
}