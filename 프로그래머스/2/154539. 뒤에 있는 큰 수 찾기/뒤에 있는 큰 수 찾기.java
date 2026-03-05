import java.util.*;

class MyMap {
    int value;
    int index;
    
    public MyMap(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        PriorityQueue<MyMap> pq = new PriorityQueue<>((a, b) -> {
            return a.value - b.value;
        });
        
        for (int i = 0; i < numbers.length; i++) {
            while (!pq.isEmpty() && pq.peek().value < numbers[i]) {
                answer[pq.poll().index] = numbers[i];
            }
            pq.add(new MyMap(numbers[i], i));
        }
        
        // 마지막까지 안 빠진 인덱스들에는 -1 기록
        while (!pq.isEmpty()) {
            answer[pq.poll().index] = -1;
        }
        
        return answer;
    }
}