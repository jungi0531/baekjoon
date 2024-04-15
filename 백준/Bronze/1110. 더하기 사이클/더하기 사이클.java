import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int input = scanner.nextInt();
		scanner.close();
		
		int temp = input;
		while (true) {
			temp = (((temp / 10) + (temp % 10)) % 10) + ((temp % 10) * 10);
			count++;
			if (temp == input) break;
		}
		System.out.println(count);
	}
}