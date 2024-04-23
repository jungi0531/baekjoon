import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] count = new int[10];
		int input = scanner.nextInt();
		scanner.close();
		
		while (input > 0) {
			count[input % 10]++;
			input /= 10;
		}
		
		count[6] = (count[6] + count[9] + 1) / 2;
		count[9] = count[6];
		
		Arrays.sort(count);
		System.out.println(count[9]);
	}
}