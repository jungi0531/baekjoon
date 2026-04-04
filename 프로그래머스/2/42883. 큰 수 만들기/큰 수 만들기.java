import java.util.*;

class Solution {
    public String solution(String number, int k) {
        /*
        number 범위 및 k 보니까 완전 탐색 같은 건 안 될 듯 n으로 끝나야 함?
        앞에 작은 수가 있으면 그걸 뺀다?
        스택 사용? k만큼 뺄 때까지
        */
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() < number.charAt(i) - '0') {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i) - '0');
        }
        
        StringBuilder sb = new StringBuilder("");
        while (k > 0) {
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}