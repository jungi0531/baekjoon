import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int coupleCount = 0;
		
		int len = scanner.nextInt();
		String input = scanner.next();
		
		for (int i = 0; i < len; i++) {
			if (input.charAt(i) == 'L') {
				coupleCount++;
				i++;
			}
		}
		if (coupleCount < 2) 
			System.out.println(len);
		else
			System.out.println(len - (coupleCount - 1));
		
		scanner.close();
	}
}