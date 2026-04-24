import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        /**
        pq 만들어서 하기
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int temp : scoville) {
            pq.add(temp);
        }
        //
        while (pq.peek() < K && pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + (b * 2));
            count++;
        }
        //
        if (pq.peek() < K) return -1;
        return count;
    }
}