import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hash = new HashSet<>();
        // dfs로 해야하는 거 같은데 3가지 경우를 최소 연산이니까 bfs? 음..
        q.add(x);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int remove = q.poll();
                if (remove == y) return answer;

                if (remove * 3 <= y && !hash.contains(remove * 3)) {
                    hash.add(remove * 3);
                    q.add(remove * 3);
                }
                if (remove * 2 <= y && !hash.contains(remove * 2)) {
                    hash.add(remove * 2);
                    q.add(remove * 2);
                }
                if (remove + n <= y && !hash.contains(remove + n)) {
                    hash.add(remove + n);
                    q.add(remove + n);
                }
            }
            
            answer++;
        }
        
        return -1;
    }
}