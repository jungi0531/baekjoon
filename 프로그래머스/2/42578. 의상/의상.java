import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        /**
        걍 확통 문제
        */
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int result = 1;
        for (String temp : map.keySet()) {
            result *= map.get(temp) + 1;
        }
        return result - 1;
    }
}