import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 해시에 넣어서 두 개씩 빼고 넣기 peek() >= K 일 때까지
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add((long)scoville[i]);
        }
        
        while (pq.size() >= 2 && pq.peek() < K) {
            Long a = pq.poll();
            Long b = pq.poll();
            pq.add(a + (b * 2));
            answer++;
        }
        
        if (pq.peek() < K) return -1;
        return answer;
    }
}