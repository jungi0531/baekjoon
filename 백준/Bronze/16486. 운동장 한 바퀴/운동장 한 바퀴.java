import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int d1 = scanner.nextInt();
		int d2 = scanner.nextInt();
		double pi = 3.141595;
		
		System.out.println((d1 * 2) + (2 * pi * d2));
		
		scanner.close();
	}
}