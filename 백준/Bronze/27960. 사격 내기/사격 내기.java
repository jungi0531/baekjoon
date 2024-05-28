import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = 0;
		
		for (int i = 512; i > 0; i/=2) {
			if ((A - i) >= 0 && (B - i) >= 0) {
				A -= i;
				B -= i;
			}
			else if ((A - i) >= 0) {
				A -= i;
				C += i;
			}
			else if ((B - i) >= 0) {
				B -= i;
				C += i;
			}
		}
		System.out.println(C);
		
		scanner.close();
	}
}