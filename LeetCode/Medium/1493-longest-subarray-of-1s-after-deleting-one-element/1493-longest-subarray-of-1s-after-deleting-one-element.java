class Solution {
    public int longestSubarray(int[] nums) {
        /**
        이 전이랑 비슷한 문제인 듯한데
        무조건 하나를 지울 수 있을 때, 가장 긴 1 배열의 길이 반환
        */
        int left = 0;
        int right = 0;
        int max = 0;
        int zeroCount = 0;
        int oneCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            right++;

            while (zeroCount > 1) {
                if (nums[left] == 0) zeroCount--;
                else oneCount--;
                left++;
            }

            max = Math.max(max, zeroCount + oneCount - 1);
        }

        return max;
    }
}