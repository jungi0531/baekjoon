import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		for (int i = 0; i < input; i++) {
			for (int j = i; j < input; j++)
				System.out.print("*");
			System.out.println();
		}
		
		scanner.close();
	}
}