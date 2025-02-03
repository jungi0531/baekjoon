import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
        {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push"))
            {
                stack.push(Integer.parseInt(input[1]));
            }
            else if (input[0].equals("pop"))
            {
                if (stack.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(stack.pop());
            }
            else if (input[0].equals("size"))
            {
                System.out.println(stack.size());
            }
            else if (input[0].equals("empty"))
            {
                if (stack.isEmpty())
                    System.out.println("1");
                else
                    System.out.println("0");
            }
            else if (input[0].equals("top"))
            {
                if (stack.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(stack.peek());
            }
        }
    }
}