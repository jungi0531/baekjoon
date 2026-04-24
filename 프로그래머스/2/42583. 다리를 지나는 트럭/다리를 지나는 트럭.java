import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        /**
        다리에 있는 트럭을 큐로 관리하고 무게는 따로 관리해서 다리를 관리.
        트럭의 무게와 드가는 시간까지 같이 넣기
        드갈 때 현재 시간 넣고 뺄 때 현재 시간 - 드간 시간 >= 다리 길이면 빼기
        */
        Queue<int[]> bridge = new LinkedList<>();
        
        int count = 0;
        int time = 0;
        int total = 0;
        while (count < truck_weights.length) {
            // 빼기
            if (!bridge.isEmpty()) {
                if (time - bridge.peek()[1] >= bridge_length) {
                    int[] remove = bridge.poll();
                    total -= remove[0];
                }
            }
            // 넣기
            if (total + truck_weights[count] <= weight) {
                bridge.add(new int[]{truck_weights[count], time});
                total += truck_weights[count];
                count++;
            }
            //
            time++;
        }
        // 큐 다 빼기
        for (int[] temp : bridge) {
            time += bridge_length - (time - temp[1]);
        }
        return time + 1;
    }
}