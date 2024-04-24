import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		if (input >= 620) System.out.println("Red");
		else if (input >= 590) System.out.println("Orange");
		else if (input >= 570) System.out.println("Yellow");
		else if (input >= 495) System.out.println("Green");
		else if (input >= 450) System.out.println("Blue");
		else if (input >= 425) System.out.println("Indigo");
		else System.out.println("Violet");
		
		scanner.close();
	}
}