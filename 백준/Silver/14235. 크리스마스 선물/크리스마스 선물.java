import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("0")) {
                if (pq.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(pq.poll());
            }
            else {
                for (int ii = 0; ii < Integer.parseInt(input[0]); ii++) {
                    pq.add(Integer.parseInt(input[ii + 1]));
                }
            }
        }
    }
}