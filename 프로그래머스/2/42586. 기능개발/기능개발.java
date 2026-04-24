import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        /**
        하루마다 speeds만큼 진적되고 100되면 끝인데? 앞에가 아직 100이 안 됐으면 못 뺀다.
        */
        int done = 0;
        Queue<Integer> q = new LinkedList<>();
        
        while (done < progresses.length) {
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            int count = 0;
            while (done < progresses.length && progresses[done] >= 100) {
                done++;
                count++;
            }
            if (count != 0) q.add(count);
        }
        //
        int[] answer = new int[q.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }
        return answer;
    }
}