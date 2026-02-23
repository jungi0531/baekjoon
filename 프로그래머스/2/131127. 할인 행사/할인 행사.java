import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 해시맵에 넣어서 돌기 같은데
        // 그리고 마트 할인에서도 우선 해시 맵에 다 넣어놓고 하나 넣고 하나 빼면서 슬라이드 윈도우
        // 하나의 해시맵에서 할 수 있나? 0이 되면 없애고
        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            hash.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            hash.put(discount[i], hash.getOrDefault(discount[i], 0) - 1);
            if (hash.get(discount[i]) == 0) hash.remove(discount[i]);
        }
        
        int answer = 0;
        if (hash.size() == 0) answer++;
        
        int start = 0;
        int end = 10;
        while (end < discount.length) {
            
            hash.put(discount[start], hash.getOrDefault(discount[start], 0) + 1);
            if (hash.get(discount[start]) == 0) hash.remove(discount[start]);
            
            hash.put(discount[end], hash.getOrDefault(discount[end], 0) - 1);
            if (hash.get(discount[end]) == 0) hash.remove(discount[end]);
            
            
            if (hash.size() == 0) answer++;
            
            start++;
            end++;
        }
        
        
        return answer;
    }
}