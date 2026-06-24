import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        // RD만 들어오는데 여기서 어떻게 해야하나?
        // R과 D에 해당하는 큐를 각각 만들고 큐에 뭐가 있으면 하나 빼고 스킵 아니면 공격 가능
        // 하나만 있는 경우도 봐야함..
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        int rCount = 0;
        int dCount = 0;
        //
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                q.add(0);
                rCount++;
            }
            else {
                q.add(1);
                dCount++;
            }
        }
        
        while (q.size() > 1 && (rCount > 0 && dCount > 0)) {
            if (q.peek() == 0) {
                if (d.isEmpty()) {
                    r.add(0);
                    q.add(q.poll());
                } else {
                    d.poll();
                    q.poll();
                    rCount--;
                }
            } else {
                if (r.isEmpty()) {
                    d.add(0);
                    q.add(q.poll());
                } else {
                    r.poll();
                    q.poll();
                    dCount--;
                }
            }
        }
        //
        if (q.peek() == 0) return "Radiant";
        return "Dire";
    }
}