import java.util.*;

class Solution {
    public int solution(int[] nums) {
        /**
        N마리 중 N / 2마리를 고르는데 최대한 다양한 종류의 포켓몬을 고르려면
        종류를 체크하고 Math.min(종류, N/2) 출력?
        */
        int answer = 0;
        HashSet<Integer> hash = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            hash.add(nums[i]);
        }
        
        return Math.min(hash.size(), nums.length / 2);
    }
}