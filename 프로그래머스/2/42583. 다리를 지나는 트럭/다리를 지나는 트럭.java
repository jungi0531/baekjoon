import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int i = 0;
        int count = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        
        // 큐를 만들고 넣긴 넣는데
        // 다리의 길이를 고려해야함 머 몇 초 뒤에 빼고 그런게 되나?
        // 초당 하나를 넣고 / 트럭을 넣기 전 다리의 길이만큼 빈 값을 넣기?
        // q.size() 가 bridge_length가 될만큼 
        while (count < truck_weights.length) {
            // q.size() 가 bridge.length가 되게 계속 채워 넣어
            while (q.size() < bridge_length - 1) {
                q.add(0);
            }
            if (i < truck_weights.length && weight >= sum + truck_weights[i]) {
                // 넣을 수 있을 땐 넣기
                q.add(truck_weights[i]);
                sum += truck_weights[i];
                i++;
            }
            if (q.peek() > 0) count++;
            sum -= q.poll();
            time++;
            if (count >= truck_weights.length) {
                time++;
                break;
            }
        }
        
        return time;
    }
}