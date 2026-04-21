class Solution {
    public void moveZeroes(int[] nums) {
        /**
        버블 소트 느낌으로 0 오른쪽으로 밀기
        */
        
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;

            swap(nums, i, p);
            p++;
        }
    }
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}