import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		
		if (B - A > C - B) {
			System.out.println(B - A - 1);
		}
		else {
			System.out.println(C - B - 1);
		}
		
		scanner.close();
	}
}