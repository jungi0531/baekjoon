import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] alphabet = new int[26];
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		scanner.close();
		
		for (int i = 0; i < input.length(); i++) {
			alphabet[input.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}
}