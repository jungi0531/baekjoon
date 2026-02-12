import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 동명이인 있을 수 있으니 HashMap으로 사람 수까지 카운팅 하고
        // 걍 HashMap에 넣어서 contains 하고 있으면 -- 해야겠네
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            hash.put(participant[i], hash.getOrDefault(participant[i], 0) + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            if (hash.containsKey(completion[i])) {
                hash.put(completion[i], hash.get(completion[i]) - 1);
                if (hash.get(completion[i]) == 0) {
                    hash.remove(completion[i]);
                }
            }
        }
        for (String temp : hash.keySet()) {
            return temp;
        }
        
        return answer;
    }
}