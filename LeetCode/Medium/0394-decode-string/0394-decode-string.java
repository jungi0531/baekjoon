import java.util.*;

class Solution {
    public String decodeString(String s) {
        /**
        
        */

        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder sb = new StringBuilder("");
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(num);
                stringStack.push(sb);

                sb = new StringBuilder("");
                num = 0;
            } else if (c == ']') {
                int repeat = stack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prev.append(sb);
                }

                sb = prev;
            } else {
                sb.append(c);
            }
        }
        //
        return sb.toString();
    }
}