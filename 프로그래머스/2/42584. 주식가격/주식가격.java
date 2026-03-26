import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 스택을 활용해서 스택에 계속 넣다가? 낮아지면 나온 숫자와 같아질 때까지 숫자 빼기
        // 스택의 첫 값은 인덱스, 두 번째 값은 값
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            // 스택에 들어있는 값보다 현재 값이 작으면 떨어진 거라서
            // 스택에 들어있는 값과 같거나 클 때까지 빼기
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] remove = stack.pop();
                answer[remove[0]] = i - remove[0];
            }
            stack.push(new int[]{i, prices[i]});
        }
        while (!stack.isEmpty()) {
            int[] remove = stack.pop();
            answer[remove[0]] = (prices.length - 1) - remove[0];
        }
        
        return answer;
    }
}