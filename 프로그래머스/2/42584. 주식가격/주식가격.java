import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        /**
        각 인덱스의 수들이 언제까지 안 떨어졌는지 기록
        스택에 넣고 스택에 있는 것보다 작은 게 나오면 스택에 있는 거보다 큰 게 나올 때까지 빼면서 기록
        */
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int remove = stack.pop();
                result[remove] = i - remove;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int remove = stack.pop();
            result[remove] = prices.length - remove - 1;
        }
        return result;
    }
}