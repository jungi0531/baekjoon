import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		long ans;
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		
		scanner.close();
		
		if (B >= C) {
			System.out.println(-1);
			return;
		}
		else {
			ans = (-A / (B - C)) + 1;
			System.out.println(ans);
		}
	}
}
