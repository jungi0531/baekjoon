import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] input = new String[5];
		boolean exist = false;
		
		for (int i = 0; i < 5; i++) {
			input[i] = scanner.nextLine();
		}

		for (int i = 0; i < 5; i++) {
			if (input[i].contains("FBI")) {
				System.out.printf("%d ", i + 1);
				exist = true;
			}
		}

		if (!exist) {
			System.out.println("HE GOT AWAY!");
		}
		
		scanner.close();
	}
}