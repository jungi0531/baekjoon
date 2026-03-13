import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 해시맵에 넣는 건가 그 해당하는 문자에 대한 값을 
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int number = 27;
        //
        for (int i = 0; i < 26; i++) {
            Character temp = (char)('A' + i);
            map.put(temp.toString(), i + 1);
        }
        for (int i = 0; i < msg.length(); i++) {
            int ii = 0;
            for (ii = msg.length(); ii > i; ii--) {
                if (map.containsKey(msg.substring(i, ii))) {
                    break;
                }
            }
            // 해당 값에 대한 걸 result에 넣고 map에 다음 조합 추가
            result.add(map.get(msg.substring(i, ii)));
            if (ii < msg.length() - 1) {
                map.put(msg.substring(i, ii) + msg.substring(ii, ii + 1), number++);
            }
            i = ii - 1;
        }
        
        
        //
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}