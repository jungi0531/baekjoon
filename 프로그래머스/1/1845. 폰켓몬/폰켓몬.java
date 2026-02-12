import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 해시맵에 다 넣고 answer = Math.max(nums.length, hash.size());
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        
        int answer = Math.min(nums.length / 2, hash.size());
        
        return answer;
    }
}