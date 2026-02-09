import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // 두 개의 해시를 만들고 한 해시에서 다른 해시로 옮겨담기
        int answer = 0;
        HashSet<Integer> hash1 = new HashSet<>();
        HashMap<Integer, Integer> hash2 = new HashMap<>();
        // 우선 두 번째 해시에 다 넣고
        for (int i = 0; i < topping.length; i++) {
            hash2.put(topping[i], hash2.getOrDefault(topping[i], 0) + 1);
        }
        // 해시에서 하나씩 빼서 다른 해시에 넣고 개수 비교
        for (int i = 0; i < topping.length; i++) {
            hash1.add(topping[i]);
            hash2.put(topping[i], hash2.get(topping[i]) - 1);
            if (hash2.get(topping[i]) == 0) hash2.remove(topping[i]);
            if (hash1.size() == hash2.size()) answer++;
        }
        
        return answer;
    }
}