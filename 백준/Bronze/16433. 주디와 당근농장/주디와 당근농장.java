import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int R = scanner.nextInt();
		int C = scanner.nextInt();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if ((i + j) % 2 == (R + C) % 2) System.out.print("v");
				else System.out.print(".");
			}
			System.out.println();
		}		
		scanner.close();
	}
}