import java.util.*;

class Solution {
    static int count;
    static boolean[] visited;
    
    public int solution(int[] cards) {
        // 가장 큰 무리 2개의 곱 리턴
        // pq의 연 거 개수 넣어놓으면 되겠는데
        // 안 열린 게 없을 때까지 깐 다음에 두 개 빼서 곱하기
        // pq의 사이즈가 1이면 0 리턴
        // bfs 라고 해야하나?
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        visited = new boolean[cards.length];
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                count = 0;
                dfs(cards, i);
                pq.add(count);
                //System.out.println(count);
            }
        }
        if (pq.size() == 1) return 0;
        
        int answer = pq.poll();
        answer *= pq.poll();
        return answer;
    }
    public void dfs(int[] cards, int num) {
        count++;
        visited[num] = true;
        if (!visited[cards[num] - 1]) {
            dfs(cards, cards[num] - 1);
        }
    }
}