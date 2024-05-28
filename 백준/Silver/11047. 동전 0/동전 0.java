import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		int[] coin = new int[N];
		
		for (int i = 0; i < N; i++) {
			coin[i] = scanner.nextInt();
		}
		
		for (int i = N - 1; i >= 0; i--) {
			while (K - coin[i] >= 0) {
				K -= coin[i];
				count++;
			}
		}
		
		System.out.println(count);
		
		scanner.close();
	}
}