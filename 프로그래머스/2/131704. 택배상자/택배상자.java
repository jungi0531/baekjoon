import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int belt = 1;
    
        while (count < order.length) {
            if (order[count] == belt) {
                // 1. 벨트 보기
                belt++;
                count++;
            } else if (!stack.isEmpty() && stack.peek() == order[count]) {
                // 2. 스택 보기
                stack.pop();
                count++;
            } else {
                // 3. 둘다 없으면 벨트에서 나올 때까지 스택에 넣고 다시
                while (order[count] >= belt) {
                    stack.push(belt);
                    belt++;
                }
                if (stack.peek() != order[count]) break;
            }
        }

        return count;
    }
}