import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		scanner.close();
		
		int[] array = new int[1000];
		
		for (int i = 1; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				if (count >= 1000) break;
				array[count] = i;
				count++;
			}
		}
		
		for (int i = a - 1; i < b; i++)
			sum += array[i];
		
		System.out.println(sum);
	}
}