import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        /**
        한 숫자가 나오면 다른 숫자가 나올 때까지 스킵
        */
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
            while (i + 1 < arr.length && arr[i] == arr[i + 1]) i++;
        }
        
        int[] answer = new int[q.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }
        return answer;
    }
}