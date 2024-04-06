import java.util.Scanner;

public class Main{
	static long[][] array = new long[30][30];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N, M;
		
		for (int i = 1; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				if (j == 0 || i == j)
					array[i][j] = 1;
				else 
					array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
			}
		}
		
		int count = scanner.nextInt();
		
		for (int i = 0; i < count; i++) {
			N = scanner.nextInt();
			M = scanner.nextInt();
			System.out.println(array[M][N]);
		}
		scanner.close();
	}
}