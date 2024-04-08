import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int answer = 0;
		int X = scanner.nextInt();
		
		int i = 64;
		while (i > 0 && X != 0) {
			if (i <= X) {
				answer++;
				X -= i;
			}
			i /= 2;
		}
		System.out.println(answer);
		scanner.close();
	}
}