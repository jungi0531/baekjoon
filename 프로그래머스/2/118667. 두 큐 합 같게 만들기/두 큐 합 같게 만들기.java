import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 빼고 넣는 기준을 만들 수 있나? -> No 그냥 갈기다 보면 되는 거 같음.
        // 최소 경우를 찾는 거라고 하면 모든 경우를 다 보고 찾으라는 건데..
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        while (sum1 != sum2) {
            if (sum1 >= sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.poll());
            } else {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.poll());
            }
            answer++;
            if (answer > 600_000) return -1;
        }
        
        return answer;
    }
}