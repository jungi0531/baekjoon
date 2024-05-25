import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < i; j++) 
				System.out.print(" "	);
			for (int j = 0; j < 2 * (input - i) - 1; j++) 
				System.out.print("*");
			System.out.println();
		}
		for (int i = 1; i < input; i++) {
			for (int j = i; j < input - 1; j++)
				System.out.print(" ");
			 for (int j = 0; j < 2 * i + 1; j++)
				 System.out.print("*");
			 System.out.println();
		}
		
		scanner.close();
	}
}