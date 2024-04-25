import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int input;
		int count = 0;
		while (true) {
			if (scanner.hasNext()) {
				input = scanner.nextInt();
				if (input > 0) count++;
			}
			else break;
		}
		scanner.close();
		System.out.println(count);
	}
}