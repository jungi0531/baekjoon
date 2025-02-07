import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "yes";
        Stack<Character> stack = new Stack<>();

        while (true)
        {
            String input = br.readLine();
            if (input.equals("."))
                break;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(' || input.charAt(i) == '[')
                    stack.add(input.charAt(i));
                else if (input.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        answer = "no";
                        break;
                    }
                    else {
                        if (stack.peek() == '(')
                            stack.pop();
                        else {
                            answer = "no";
                            break;
                        }
                    }
                }
                else if (input.charAt(i) == ']') {
                    if (stack.isEmpty()) {
                        answer = "no";
                        break;
                    }
                    else {
                        if (stack.peek() == '[')
                            stack.pop();
                        else {
                            answer = "no";
                            break;
                        }
                    }
                }
            }
            if (!stack.isEmpty())
                answer = "no";
            System.out.println(answer);
            answer = "yes";
            stack.clear();
        }
    }
}