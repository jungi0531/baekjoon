import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		int result = reverseInt(a) + reverseInt(b);
		result = reverseInt(result);
		
		System.out.println(result);
		
		scanner.close();
	}
	public static int reverseInt(int n) {
		int temp = 0;
		while (n > 0) {
			temp *= 10;
			temp += n % 10;
			n /= 10;
		}
		return temp;
	}
}