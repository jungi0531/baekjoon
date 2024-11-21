import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (true) {
            if (pq.peek() >= K) break;
            int temp = pq.poll();
            if (pq.isEmpty()) {
                answer = -1;
                break;
            }
            temp = temp + (pq.poll() * 2);
            pq.add(temp);
            answer++;
        }
        
        return answer;
    }
}