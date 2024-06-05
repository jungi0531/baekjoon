import java.lang.annotation.Target;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int max, min;
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int K = scanner.nextInt();
		
		max = N - (M * K);
		if (max < 0)
			max = 0;
		
		min = N - (M * (K - 1) + 1);
		
		if (min < 0)
			min = 0;
		
		System.out.println(max + " " + min);
		
		scanner.close();
	}
}