import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

class abs implements Comparable<abs> {
    int num;

    public abs(int num) {
        this.num = num;
    }
    @Override
    public int compareTo(abs other) {
        if (Math.abs(this.num) != Math.abs(other.num))
            return (Math.abs(this.num) - Math.abs(other.num));
        return (this.num - other.num);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<abs> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.equals("0")) {
                if (pq.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(pq.poll().num);
            }
            else
                pq.add(new abs(Integer.parseInt(input)));
        }
    }
}