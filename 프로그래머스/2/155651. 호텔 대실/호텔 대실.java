import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            int start = toMinutes(book_time[i][0]);
            int end = toMinutes(book_time[i][1]) + 10;
            list.add(new int[]{start, end});
        }
        list.sort((a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] time : list) {
            int start = time[0];
            int end = time[1];
            
            // pq에 넣은 것 중 가장 빨리 끝나는 것보다 시작 시간이 늦으면 그대로 넣기
            // 비어 있거나 넣을 수 있는 경우
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            pq.add(end);
        }
        // 이후 pq의 사이즈를 리턴
        
        return pq.size();
    }
    public int toMinutes(String s) {
        String[] time = s.split(":");
        int result = Integer.parseInt(time[0]) * 60;
        result += Integer.parseInt(time[1]);
        
        return result;
    }
}