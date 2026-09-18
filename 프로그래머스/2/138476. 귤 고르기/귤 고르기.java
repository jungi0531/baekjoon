import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 개수 가장 많은 순으로 정렬하기
        // 해시맵에 key 값은 귤 크기, value 값은 개수
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        for (Integer temp : map.keySet()) {
            pq.add(map.get(temp));
        }
        
        int count = 0;
        
        while (k > 0) {
            k -= pq.poll();
            count++;
        }
        
        return count;
    }
}