import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 우선 한바퀴 돌 때마다 추가해서 저장해놓고 100이 넘어가면 배포하는 건데, 앞에 100이 안 되면 배포가 안 된다
        // 그 순간에 100 넘은 숫자들 개수를 스피드에 넣고 count++;
        // 한 바퀴 돌 떄마다 100 다 뛰어 넘고 오기
        int deployCount = 0;
        int deployed = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        
        while (deployed < progresses.length) {
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                
            }
            int cur = 0;
            while (deployed < progresses.length &&
                   progresses[deployed] >= 100) {
                deployed++;
                cur++;
            }
            if (cur != 0) arr.add(cur);
        }
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}