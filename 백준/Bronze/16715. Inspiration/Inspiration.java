import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int temp, idx = 0, max = 0;
		int sum;
		int N = scanner.nextInt();
		
		for (int i = 2; i <= N; i++) {
			sum = 0;
			temp = N;
			while (temp > 0) {
				sum += temp % i;
				temp /= i;
			}
			if (max < sum) {
				max = sum;
				idx = i;
			}
		}
		System.out.println(max + " " + idx);
		scanner.close();
	}
}