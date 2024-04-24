import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int num;
		double dt, A, B, fly, result;
		
		for (int i = 0; i < n; i++) {
			num = scanner.nextInt();
			dt = scanner.nextDouble();
			A = scanner.nextDouble();
			B = scanner.nextDouble();
			fly = scanner.nextDouble();
			
			result = (dt / (A + B)) * fly;
			System.out.printf("%d %.6f\n", num, result);
		}
		scanner.close();

	}
}