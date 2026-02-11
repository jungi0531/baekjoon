import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 스택으로 떨어졌으면 어디까지 떨어졌는지 확인
        // 
        // 그냥 해당 인덱스 넣다가 수가 줄어드는 인덱스 만나면 해당
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            if (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
            }
            stack.push(i);
        }
        for (int i = 0; i < prices.length; i++) {
            if (answer[i] == 0) {
                answer[i] = prices.length - (i + 1);
            }
        }
        
        return answer;
    }
}