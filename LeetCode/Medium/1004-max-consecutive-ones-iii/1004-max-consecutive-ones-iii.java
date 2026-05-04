class Solution {
    public int longestOnes(int[] nums, int k) {
        /**
        최대 k개의 0을 뒤집어서 가장 긴 1의 길이 구하기
        걍 슬라이딩 윈도우 해서 0의 개수가 k보다 작으면 늘리고 k보다 크면 줄이고 하면 되지 않나?
        */
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int oneCount = 0;
        int max = 0;

        while (right < nums.length) {
            if (nums[right] == 0) zeroCount++;
            else oneCount++;
            right++;

            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                else oneCount--;
                left++;
            }
            max = Math.max(max, oneCount + zeroCount);
        }

        return max;
    }
}