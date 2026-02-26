import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // size가 캐시 사이즈만큼 되는데 hit 면 나두고 없으면 교체
        // 큐랑 해시 두 개로 관리?
        int answer = 0;
        
        List<String> arr = new LinkedList<>();
        
        for (int i = 0; i < cities.length; i++) {
            String input = cities[i].toLowerCase();
            
            if (arr.contains(input)) {
                answer++;
                arr.remove(input);
                arr.add(input);
            } else {
                answer += 5;
                
                arr.add(input);
                if (arr.size() > cacheSize) {
                    arr.remove(0);
                }
            }
            
        }
        
        return answer;
    }
}