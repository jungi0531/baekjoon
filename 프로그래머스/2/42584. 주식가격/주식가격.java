import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<int[]> stack = new Stack<>();
        // 먼가 스택인 거 같은데
        // 계속 스택에 넣다가 더 작은 수가 나오면 pop하고 넣어서 해당 인덱스에 기록?
        // prices 정보만으로 하는 게 가능한가? push 당시 인덱스도 필요할 거 같은데
        for (int i = 0; i < prices.length; i++) {
            // 주식이 떨어져있으면 근데 이거는 멀리는 못 보는데
            if (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                    int[] remove = stack.pop();
                    answer[remove[0]] = i - (remove[0]);
                }
            }
            stack.push(new int[]{i, prices[i]});
            
        }
        
        // 마지막까지 안 떨어진 주식들
        while (!stack.isEmpty()) {
            int[] remove = stack.pop();
            answer[remove[0]] = prices.length - (remove[0] + 1);
        }
        
        return answer;
    }
}