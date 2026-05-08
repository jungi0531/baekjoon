class Solution {
    public int pivotIndex(int[] nums) {
        /**
        하나 중간에 비우고 양 옆의 합이 같도록 하는 인덱스. 없으면 -1 반환
        비우는 인덱스를 첨부터 끝까지 구하기
        */
        int leftSum = 0;
        int rightSum = 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        while (index < nums.length - 1 && leftSum != rightSum) {
            leftSum += nums[index];
            index++;
            rightSum -=nums[index];
        }

        if (index >= nums.length && leftSum != rightSum) return -1;
        return index;
    }
}