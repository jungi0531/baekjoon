import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N, M;
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		System.out.println((N * M) - 1);
		
		scanner.close();
	}
}