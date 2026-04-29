class Solution {
    public double findMaxAverage(int[] nums, int k) {
        /**
        k 길이의 서브 어레이의 최대 평균을 찾아라
        */
        double max = Integer.MIN_VALUE;
        double avg = 0;
        
        for (int i = 0; i < k; i++) {
            avg += (double)nums[i] / k;
        }
        max = Math.max(max, avg);
        for (int i = k; i < nums.length; i++) {
            avg += (double)nums[i] / k;
            avg -= (double)nums[i - k] / k;
            max = Math.max(max, avg);
        }

        return max;
    }
}