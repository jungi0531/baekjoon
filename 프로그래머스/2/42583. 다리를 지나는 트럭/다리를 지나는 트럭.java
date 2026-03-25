import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 큐에 있는 트럭의 총 합이 weight 보다 작아야 함
        // 또한 트럭의 개수가 다리 길이보다 넘지 못 함
        Queue<int[]> bridge = new LinkedList<>();
        int sum = 0;
        int time = 0;
        int i = 0;
        while (i < truck_weights.length) {
            time++;
            
            // 추가하면서 동시에 빠질 수도 있음
            // 언제 빠지는데? 현재 시간 - 들온 시간이 다리 길이일 때 <- 들온 시간을 알아야 함
            // 빠지면서 들어가니까 빠지는 거 먼저
            // 다리에 있던 시간이 다리 길이보다 커야함
            if (!bridge.isEmpty() && time - bridge.peek()[0] >= bridge_length) {
                int[] remove = bridge.poll();
                sum -= remove[1];
                time = remove[0] + bridge_length;
            }
            
            // 빠지고 나서 들어가기.
            if (sum + truck_weights[i] <= weight) {
                // 추가해도 견딜 수 있는 무게면
                bridge.add(new int[]{time, truck_weights[i]});
                sum += truck_weights[i];
                i++;
            }
        }
        // 트럭이 다 다리 안에 있으면 마지막에 나온 트럭의 time + 다리 길이
        while (!bridge.isEmpty()) {
            int[] remove = bridge.poll();
            time = remove[0] + bridge_length;
        }
        
        return time;
    }
}