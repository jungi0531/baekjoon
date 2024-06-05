import java.lang.annotation.Target;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		TreeSet<Integer> ts = new TreeSet<>();
		int T = scanner.nextInt();
		int K;
		
		int count;
		int temp, hour, min;
		int num = 0, best;
		
		for (int i = 0; i < T; i++) {
			ts.clear();
			count = 0;
			best = Integer.MAX_VALUE;
			
			K = scanner.nextInt();
			for (int j = 0; j < K; j++) {
				ts.add(scanner.nextInt());
			}
			
			K = scanner.nextInt();
			for (int j = 0; j < K; j++) {
				temp = scanner.nextInt();
				hour = scanner.nextInt();
				min = scanner.nextInt();
				
				if (hour == -1 || min == -1) continue;
				if (ts.contains(temp)) {
					if (hour * 60 + min <= 360) {
						count++;
						if (best > hour * 60 + min) {
							best = hour * 60 + min;
							num = temp;
						}
					}
				}
			}
			System.out.println(num + " " + count);
		}
		scanner.close();
	}
}