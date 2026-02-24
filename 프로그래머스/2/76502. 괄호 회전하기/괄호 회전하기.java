import java.util.*;

class Solution {
    static Stack<Integer> stack;
    
    public int solution(String s) {
        stack = new Stack<>();
        int answer = 0;
        
        //s = "(";
        for (int i = 0; i < s.length(); i++) {
            String input = s.substring(i, s.length()) + s.substring(0, i);
            //System.out.println(s.substring(i, s.length()) + " " + s.substring(0, i));
            
            if (check(input)) answer++;
        }
        
        return answer;
    }
    public boolean check(String input) {
        stack.clear();
        
        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) return false;
                
                int remove = stack.peek();
                if ((cur == ')' && remove != '(') ||
                    (cur == ']' && remove != '[') ||
                    (cur == '}' && remove != '{')) {
                    return false;
                } 
                stack.pop();
            }
        }
        
        if (!stack.isEmpty()) return false;
        return true;
    }
}