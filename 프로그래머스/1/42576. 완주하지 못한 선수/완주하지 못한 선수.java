import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        /**
        맵에다가 개수까지 넣어서 없애야함
        */
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
            if (map.get(completion[i]) == 0) map.remove(completion[i]);
        }
        
        String answer = "";
        
        for (String temp : map.keySet()) {
            answer = temp;
        }
        
        return answer;
    }
}