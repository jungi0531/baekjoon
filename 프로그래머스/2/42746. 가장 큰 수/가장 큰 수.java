import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 음 뭐지? 그냥 큰 수가 앞에 있는 순서로 정렬하라는 거 같은데?
        // 13보다 9가 앞으로
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        
        // 와 다 0인 경우 고려?
        if (nums[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < numbers.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}