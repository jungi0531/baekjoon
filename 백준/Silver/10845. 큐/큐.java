import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
        {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push"))
            {
                q.add(Integer.parseInt(input[1]));
            }
            else if (input[0].equals("pop"))
            {
                if (q.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(q.poll());
            }
            else if (input[0].equals("size"))
            {
                System.out.println(q.size());
            }
            else if (input[0].equals("empty"))
            {
                if (q.isEmpty())
                    System.out.println("1");
                else
                    System.out.println("0");
            }
            else if (input[0].equals("front"))
            {
                if (q.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(q.peekFirst());
            }
            else if (input[0].equals("back"))
            {
                if (q.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(q.peekLast());
            }
        }

    }
}