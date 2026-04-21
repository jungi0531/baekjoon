class Solution {
    public void moveZeroes(int[] nums) {
        /**
        버블 소트 느낌으로 0 오른쪽으로 밀기
        */

        for (int i = 1; i < nums.length; i++) {
            int ii = i;
            while (ii - 1 >= 0 && nums[ii - 1] == 0) {
                swap(nums, ii, ii - 1);
                ii--;
            }
        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}