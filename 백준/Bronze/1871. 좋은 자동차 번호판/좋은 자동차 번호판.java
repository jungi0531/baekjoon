import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int front, rear;
		
		for (int i = 0; i < N; i++) {
			front = 0; 
			rear = 0;
			String input = scanner.next();
			for (int j = 0; j < 3; j++) {
				front += (Character.valueOf(input.charAt(j)) - 'A') * Math.pow(26, 2 - j);
			}
			input = input.substring(4, input.length());
			rear = Integer.valueOf(input);
			if (Math.abs(front - rear) <= 100)
				System.out.println("nice");
			else
				System.out.println("not nice");
		}
		scanner.close();
	}
}