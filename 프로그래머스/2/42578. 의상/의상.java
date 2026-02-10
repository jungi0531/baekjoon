import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 각 해시에 넣고, 각 해시의 size를 곱한 다음 - 1
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();
        
        for (String[] temp : clothes) {
            hash.put(temp[1], hash.getOrDefault(temp[1], 0) + 1);
        }
        
        for (String temp : hash.keySet()) {
            // System.out.println(temp + " " + hash.get(temp));
            answer *= hash.get(temp) + 1;
        }
        
        return answer - 1;
    }
}