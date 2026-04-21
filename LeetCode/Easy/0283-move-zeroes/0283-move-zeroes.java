class Solution {
    public void moveZeroes(int[] nums) {
        /**
        버블 소트 느낌으로 0 오른쪽으로 밀기
        */

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int ii = i - 1;
            while (ii - 1 >= 0 && nums[ii - 1] == 0) ii--;
            if (nums[ii] == 0) swap(nums, i, ii);
        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}