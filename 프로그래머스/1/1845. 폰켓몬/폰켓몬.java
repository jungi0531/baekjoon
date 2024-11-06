import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> hash = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        
        answer = hash.size();
        
        if (answer >= (nums.length / 2)) {
            answer = nums.length / 2;
        }
        
        return answer;
    }
}