import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		long N = scanner.nextInt();
		long M = scanner.nextInt();
		
		long result = (N * M) / 2;
		System.out.println(result);
		
		scanner.close();
	}
}