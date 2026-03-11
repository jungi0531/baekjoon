import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // 해시맵과 셋 활용
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.get(topping[i]) - 1);
            if (map.get(topping[i]) == 0) map.remove(topping[i]);
            set.add(topping[i]);
            
            if (map.size() == set.size()) answer++;
        }
        
        return answer;
    }
}