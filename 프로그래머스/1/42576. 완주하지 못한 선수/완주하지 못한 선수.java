import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hash = new HashMap<>();
        
        for (int i = 0; i < completion.length; i++) {
            if (hash.containsKey(completion[i])) {
                hash.put(completion[i], hash.get(completion[i]) + 1);
            }
            else {
                hash.put(completion[i], 1);
            }
        }
        for (int i = 0; i < participant.length; i++) {
            if (hash.containsKey(participant[i]) && hash.get(participant[i]) > 0) {
                hash.put(participant[i], hash.get(participant[i]) - 1);
            }
            else {
                answer = participant[i];
            }
        }
        
        return answer;
    }
}