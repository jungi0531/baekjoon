import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        /**
        젤 높은 우선 순위가 아니면 꺼내져도 다시 넣어야 함
        우선순위 큐를 만들고 그거에 값을 다 넣어놓고 peek() 값이랑 지금 값이랑 같으면 빼고
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            if (i == location) q.add(new int[]{priorities[i], 1});
            else q.add(new int[]{priorities[i], 0});
        }
        //
        int count = 0;
        while (!q.isEmpty()) {
            int[] remove = q.poll();
            if (remove[0] == pq.peek()) {
                count++;
                if (remove[1] == 1) return count;
                pq.poll();
            } else {
                q.add(remove);
            }
        }
        //
        return count;
    }
}