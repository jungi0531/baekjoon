import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 반환 값은 차량 번호 오름차순 청구 비용
        // 입력 한 String에 빈칸으로 split
        HashMap<String, Integer> parking = new HashMap<>(); // 주차된 시간 기록
        HashMap<String, Integer> result = new HashMap<>();  // 차량별 요금 기록
        
        for (int i = 0; i < records.length; i++) {
            String[] input = records[i].split(" ");
            if (input[2].equals("IN")) {
                // 입차면 차량 추가 및 시간 기록
                parking.put(input[1], toMinutes(input[0]));
            } else {
                // 출차면 있던 차량 시간을 추가로 기록
                int time = toMinutes(input[0]) - parking.get(input[1]);
                result.put(input[1], result.getOrDefault(input[1], 0) + time);
                parking.remove(input[1]);
            }
        }
        // 출차 기록 안 된 것들 다 정리
        for (String temp : parking.keySet()) {
            int time = toMinutes("23:59") - parking.get(temp);
                result.put(temp, result.getOrDefault(temp, 0) + time);
        }
        // 시간 계산
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for (String temp : result.keySet()) {
            int time = result.get(temp);
            //System.out.println(temp + " " + time);
            int fee = fees[1];
            time -= fees[0];
            if (time > 0) {
                if (time % fees[2] != 0) time += fees[2];
                fee += time / fees[2] * fees[3];
            }
            pq.add(new int[]{Integer.parseInt(temp), fee});
        }
        
        int[] answer = new int[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            int[] temp = pq.peek();
            //System.out.println(temp[0] + " " + temp[1]);
            answer[i] = pq.poll()[1];
        }
        
        return answer;
    }
    public int toMinutes(String input) {
        String[] temp = input.split(":");
        int hour = Integer.parseInt(temp[0]);
        int minutes = Integer.parseInt(temp[1]);
        
        return hour * 60 + minutes;
    }
}