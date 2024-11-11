import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (q.isEmpty()) {
                q.add(arr[i]);
            }
            else {
                if (q.peekLast() != arr[i]) {
                    q.add(arr[i]);
                }
            }
        }
        int i = 0;
        answer = new int[q.size()];
        while (!q.isEmpty()) {
            answer[i++] = q.poll();
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}