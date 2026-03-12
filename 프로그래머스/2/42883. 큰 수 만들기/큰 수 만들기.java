import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < number.charAt(i) - '0') {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i) - '0');
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}