class Solution {
    public int maxOperations(int[] nums, int k) {
        /**
        두 수를 더해서 k가 되는 쌍을 몇 번 nums 배열에서 제거할 수 있는지
        우선 정렬하고 왼쪽과 오른쪽 포인터의 합이 k가 될 때를 봐야겠네
        */
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right) {
            if (nums[left] + nums[right] == k) {
                count++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < k) {
                left++;
            } else {
                right--;
            }
        }
        
        return count;
    }
}