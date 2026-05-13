import java.util.*;

class Solution {
    public String removeStars(String s) {
        /**
        별이 나오면 지우는데 이전에 나온 것도 지우기
        */
        Stack<Character> stack = new Stack<>();
        //
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        //
        StringBuilder sb = new StringBuilder("");
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}