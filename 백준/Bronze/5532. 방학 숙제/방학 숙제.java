import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		int L = scanner.nextInt();
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		int D = scanner.nextInt();
		
		while (A > 0 || B > 0) {
			A -= C;
			B -= D;
			count++;
		}
		System.out.println(L - count);
		scanner.close();
	}
}