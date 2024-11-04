import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] workTime = {4, 6, 4, 10};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<String, Integer> hash = new HashMap<>();

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < 4; ii++) {
                for (int iii = 0; iii < 7; iii++) {
                    String temp = scanner.next();
                    if (!temp.equals("-")) {
                        if (hash.containsKey(temp)) {
                            hash.put(temp, hash.get(temp) + workTime[ii]);
                        }
                        else {
                            hash.put(temp, workTime[ii]);
                        }
                    }
                }
            }
        }
        for (String temp : hash.keySet()) {
            if (hash.get(temp) > max) max = hash.get(temp);
            if (hash.get(temp) < min) min = hash.get(temp);
            //System.out.println(temp + " " + hash.get(temp));
        }

        if ((max - min) <= 12) System.out.println("Yes");
        else System.out.println("No");

        scanner.close();
    }
}