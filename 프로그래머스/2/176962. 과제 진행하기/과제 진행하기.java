import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 멈춰둔 과제는 스택
        // 만약 현재 진행 중인 과제를 끝냈는데 멈춰둔 과제가 있으면 그거 하는데 새로 시작해야하는 거도 있으면 새로 시작
        // 우선 시간 순 정렬부터 해야겠네
        // 다 한 과제는 result array에 넣어놓고 마지막에 배열 변환
        // 진행 중 과제 시작 + 시간 > 가장 빠른 새로운 과제 시작 시간이면 그만큼만 하고 다시 넣어놓기
        ArrayList<String> result = new ArrayList<>();
        Stack<String[]> stack = new Stack<>();
        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
            return toMinutes(a[1]) - toMinutes(b[1]);
        });
        for (int i = 0; i < plans.length; i++) {
            pq.add(plans[i]);
        }
        
        // pq에서 빼고 뺀 거의 [1] + [2]가 peek()의 [1]보다 크면 해당 값과 이름을 스택에 넣어놓기
        int prevTime = 0;
        while (!pq.isEmpty()) {
            // 여기서 스택에서 뺄지 pq에서 뺄지는 둘 중 더 빠른 시각으로 결정
            String[] remove;
            if (!stack.isEmpty() && 
                toMinutes(pq.peek()[1]) > prevTime) {
                // 스택에서 뺐다면 할 수 있는만큼만 더 하고 다시 넣어놓기
                remove = stack.pop();
                
                int curTime = prevTime + Integer.parseInt(remove[1]);
                int nextTime = toMinutes(pq.peek()[1]);
                if (curTime > nextTime) {
                    stack.push(new String[]{remove[0], Integer.toString(curTime - nextTime)});
                } else {
                    result.add(remove[0]);
                }
                prevTime = nextTime;
            } else {
                remove = pq.poll();
                if (pq.isEmpty()) {
                    result.add(remove[0]);
                    break;
                }
                int curTime = toMinutes(remove[1]) + Integer.parseInt(remove[2]);
                int nextTime = toMinutes(pq.peek()[1]);
                if (curTime > nextTime) {
                    // 다 못 하는 경우 스택에 넣기
                    // 근데 그대로 넣으면 안 되지
                    stack.push(new String[]{remove[0], Integer.toString(curTime - nextTime)});
                } else {
                    result.add(remove[0]);
                    // 다하고 시간이 남을 시?
                    // 남는 시간동안 스택에 처리할 수 있는 거 처리
                    int freeTime = nextTime - curTime;
                    while (freeTime > 0 && !stack.isEmpty()) {
                        String[] temp = stack.pop();
                        if (freeTime - Integer.parseInt(temp[1]) < 0) {
                            stack.push(new String[]{temp[0], Integer.toString(Integer.parseInt(temp[1]) - freeTime)});
                        } else {
                            result.add(temp[0]);
                        }
                        freeTime -= Integer.parseInt(temp[1]);
                    }
                }
                prevTime = nextTime;
            }
        }
        
        // 남은 스택 처리
        while (!stack.isEmpty()) {
            result.add(stack.pop()[0]);
        }
        
        // 
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    public int toMinutes(String input) {
        String[] temp = input.split(":");
        int hour = Integer.parseInt(temp[0]);
        int minute = Integer.parseInt(temp[1]);
        
        return (hour * 60) + minute;
    }
}