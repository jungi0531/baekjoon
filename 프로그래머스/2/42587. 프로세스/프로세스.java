import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 흠 리얼 그냥 그대로 하는 건가..
        // 큐랑 피큐에 둘다 넣고 현재 뺀 게 피큐 맨 위에 있는지 확인?
        Queue<Integer> q = new LinkedList<>();
        Queue<Boolean> isLocation = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            if (i == location) isLocation.add(true);
            else isLocation.add(false);
            q.add(priorities[i]);
            pq.add(priorities[i]);
        }
        
        int answer = 1;
        while (!q.isEmpty()) {
            if (q.peek() == pq.peek()) {
                if (isLocation.peek()) break;
                q.poll();
                isLocation.poll();
                pq.poll();
                answer++;
            } else {
                q.add(q.poll());
                isLocation.add(isLocation.poll());
            }
        }
        
        return answer;
    }
}