import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int[] room = new int[5];
		int temp;
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		int[][] std = new int[2][N];
		
		for (int i = 0; i < N; i++) {
			std[0][i] = scanner.nextInt();
			std[1][i] = scanner.nextInt();
		}

		for (int i = 0; i < N; i++) {	
			if (std[1][i] == 1 || std[1][i] == 2) {
				room[0]++;
			}
			else if (std[1][i] == 3 || std[1][i] == 4) {
				if (std[0][i] == 0) {
					room[1]++;
				}
				else {
					room[2]++;
				}
			}
			else {
				if (std[0][i] == 0) {
					room[3]++;
				}
				else {
					room[4]++;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			count += room[i] / K;
			room[i] %= K;
			if (room[i] > 0)
				count++;
		}
		
		System.out.println(count);
		scanner.close();
	}
}