import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < photo.length; i++) {
            for (int ii = 0; ii < photo[i].length; ii++) {
                if (map.containsKey(photo[i][ii])) answer[i] += map.get(photo[i][ii]);
            }       
        }
        
        return answer;
    }
}